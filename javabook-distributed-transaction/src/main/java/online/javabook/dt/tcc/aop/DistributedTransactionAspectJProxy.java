package online.javabook.dt.tcc.aop;

import online.javabook.dt.tcc.annotation.BranchTxId;
import online.javabook.dt.tcc.annotation.DistributedTransaction;
import online.javabook.dt.tcc.annotation.MasterTxId;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import xyz.downgoon.snowflake.Snowflake;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class DistributedTransactionAspectJProxy {

	/**
	 * snowflake
	 */
	private static final Snowflake snowflake = new Snowflake(2, 5);

	/**
	 * txContext
	 */
	private static final ThreadLocal<TxStateTable> txStateTableThreadLocal = new ThreadLocal<>();

	@Pointcut("@annotation(online.javabook.dt.tcc.annotation.DistributedTransaction)")
	public void distributedTransaction() {}

	@Around("distributedTransaction()")
	public Object distributedTransactionAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = null;

		// get method signature
		MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
		Method method = signature.getMethod();

		// annotation
		DistributedTransaction distributedTransaction = signature.getMethod().getAnnotation(DistributedTransaction.class);
		String txName = method.toString();
		Object[] oldArgs = proceedingJoinPoint.getArgs();

		// get txStateTable
		TxStateTable txStateTable = txStateTableThreadLocal.get();

		// master distributed transaction state
		long txId = snowflake.nextId();
		if(txStateTable==null) {
			txStateTable = new TxStateTable(txName, txId, TxState.INIT);
			txStateTableThreadLocal.set(txStateTable);

			// branch distributed transaction state
		} else {
			Class[] branchArgTypes = method.getParameterTypes();
			Object branchTarget = proceedingJoinPoint.getTarget();

			Object[] newArgs = getNewArgs(txName, txId, method, oldArgs);
			txStateTable.addBranchTxState(txName, txId, TxState.INIT, branchTarget, branchArgTypes, newArgs, distributedTransaction);
		}

		try {
			// doTry
			if(txStateTable.getTxException() == null) {

				Object[] args = oldArgs;
				if(isBranchDistributedTransaction(txName)) {
					args = getNewArgs(txName, txId, method, oldArgs);
				}
				result = proceedingJoinPoint.proceed(args);

				// branch tx commit state
				if(isBranchDistributedTransaction(txName)) {
					txStateTable.setBranchTxState(txName, TxState.PREP_COMMIT);
				}
			}
		}catch (Exception exception) {

			// branch tx exception
			if(isBranchDistributedTransaction(txName)) {
				txStateTable.setBranchTxState(txName, TxState.PREP_ROLLBACK);
				txStateTable.setBranchTxException(txName, exception);
				txStateTable.setTxException(exception);

			} else if(isMasterDistributedTransaction(txName)) {
				txStateTable.setTxException(exception);
			}
		}

		// after master tx
		if(!isBranchDistributedTransaction(txName)) {

			// do branch tx commit
			if(txStateTable.isAllBranchTxPrepCommit()) {
				for (TxState branchTxState : txStateTable.getBranchTxStates().values()) {
					doCommitMethod(branchTxState);
					branchTxState.setTxState(TxState.COMMIT);
				}
				txStateTable.setMasterTxState(TxState.COMMIT);

				// do branch tx rollback
			} else if(txStateTable.isAnyBranchTxPrepRollBack()) {
				for (TxState branchTxState : txStateTable.getBranchTxStates().values()) {

					if(branchTxState.getTxException() == null && branchTxState.isPrepCommit()) {
						doRollbackMethod(branchTxState);
						branchTxState.setTxState(TxState.ROLLBACK);
					}
				}
				txStateTable.setMasterTxState(TxState.ROLLBACK);
			}

			System.out.println(txStateTable);
		}
		return result;
	}

	// ------------------------------------------------------------------------------------
	// getDoTryArgs
	// ------------------------------------------------------------------------------------

	private Object[] getNewArgs(String txName, long txId, Method method, Object[] oldArgs) {

		TxStateTable txStateTable = txStateTableThreadLocal.get();
		TxState branchTxState = txStateTable.getBranchTxState(txName);
		if(branchTxState!=null) return branchTxState.getTxArgValues();

		List<Object> newArgs = new ArrayList<>(oldArgs.length);
		Class[] parameterTypes = method.getParameterTypes();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();

		for (int index = 0; index < parameterTypes.length; index++) {
			if(parameterAnnotations[index].length > 0) {
				for (Annotation parameterAnnotation : parameterAnnotations[index]) {
					Object newArg = getNewArg(parameterAnnotation, txId);
					newArgs.add(newArg);
				}
			}
			else{
				newArgs.add(oldArgs[index]);
			}
		}

		return newArgs.toArray();
	}

	private Object getNewArg(Annotation parameterAnnotation, long txId) {
		if(parameterAnnotation != null) {
			if(parameterAnnotation instanceof MasterTxId) {
				TxStateTable txContext = txStateTableThreadLocal.get();
				return txContext.getMasterTxId();
			}
			else if(parameterAnnotation instanceof BranchTxId) {
				return txId;
			}
		}
		return null;
	}

	// ------------------------------------------------------------------------------------
	// doCommitMethod
	// ------------------------------------------------------------------------------------

	private void doCommitMethod(TxState txState)
			throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

		String methodName = txState.getDistributedTransaction().commit();
		Method method = txState.getTxTarget().getClass().getMethod(methodName, txState.getTxArgTypes());
		method.invoke(txState.getTxTarget(), txState.getTxArgValues());
	}

	// ------------------------------------------------------------------------------------
	// doRollbackMethod
	// ------------------------------------------------------------------------------------

	private void doRollbackMethod(TxState txState)
			throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

		String methodName = txState.getDistributedTransaction().rollback();
		Method method = txState.getTxTarget().getClass().getMethod(methodName, txState.getTxArgTypes());
		method.invoke(txState.getTxTarget(), txState.getTxArgValues());
	}

	// ------------------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------------------

	private boolean isMasterDistributedTransaction(String txName) {
		if(txStateTableThreadLocal.get().getMasterTxName().equals(txName)) {
			return true;
		}
		return false;
	}

	private boolean isBranchDistributedTransaction(String txName) {
		if(!txStateTableThreadLocal.get().getMasterTxName().equals(txName)) {
			return true;
		}
		return false;
	}
}
