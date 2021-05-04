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
		Object result;

		// get method signature
		MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
		Method method = signature.getMethod();

		// annotation
		DistributedTransaction distributedTransaction = signature.getMethod().getAnnotation(DistributedTransaction.class);
		String txName = method.toString();

		// old args of method
		Object[] oldArgs = proceedingJoinPoint.getArgs();
		Object[] newArgs = doTryArgs(method, oldArgs);

		// init txStateTable
		TxStateTable txStateTable = txStateTableThreadLocal.get();

		// master distributed transaction
		long txId = snowflake.nextId();
		if(txStateTable==null) {
			txStateTable = new TxStateTable(txName, txId, TxState.INIT);
			txStateTableThreadLocal.set(txStateTable);

		// branch distributed transaction
		}else{
			Class[] parameterTypes = method.getParameterTypes();
			txStateTable.addBranchTxState(txName, txId, TxState.INIT, proceedingJoinPoint.getTarget(), parameterTypes, newArgs, distributedTransaction);
		}

		try {
			// doTry
			result = proceedingJoinPoint.proceed(newArgs);

			if(!isMasterDistributedTransaction(txName)) {
				txStateTable.setBranchTxState(txName, TxState.PREP_COMMIT);
			}
		}catch (Exception exception) {
			if(!isMasterDistributedTransaction(txName)) {
				txStateTable.setBranchTxState(txName, TxState.PREP_ROLLBACK);
			}
			result = exception;
		}

		// master tx
		if(isMasterDistributedTransaction(txName)) {
			if(txStateTable.isAllBranchTxPrepCommit()) {
				for (TxState branchTxState : txStateTable.getBranchTxStates().values()) {
					doCommitMethod(branchTxState);
				}
				txStateTable.setMasterTxState(TxState.COMMIT);
			} else if(txStateTable.isAnyBranchTxPrepRollBack()) {
				for (TxState branchTxState : txStateTable.getBranchTxStates().values()) {
					doRollbackMethod(branchTxState);
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

	private Object[] doTryArgs(Method method, Object[] oldArgs) {

		List<Object> newArgs = new ArrayList<>(oldArgs.length);
		Class[] parameterTypes = method.getParameterTypes();
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();

		for (int index = 0; index < parameterTypes.length; index++) {
			if(parameterAnnotations[index].length > 0) {
				for (Annotation parameterAnnotation : parameterAnnotations[index]) {
					Object newArg = getDoTryArg(method, parameterAnnotation);
					newArgs.add(newArg);
				}
			}
			else{
				newArgs.add(oldArgs[index]);
			}
		}

		return newArgs.toArray();
	}

	private Object getDoTryArg(Method method, Annotation parameterAnnotation) {

		if(parameterAnnotation != null) {
			if(parameterAnnotation instanceof MasterTxId) {
				TxStateTable txContext = txStateTableThreadLocal.get();
				return txContext.getMasterTxId();
			}
			else if(parameterAnnotation instanceof BranchTxId) {
				String signatureName = method.toString();
				TxStateTable txStateTable = txStateTableThreadLocal.get();
				TxState branchTxState = txStateTable.getBranchTxState(signatureName);
				if(branchTxState == null) {
					return snowflake.nextId();
				}else{
					return txStateTable.getBranchTxState(signatureName).getTxId();
				}

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
		Method method = txState.getTxTarget().getClass().getMethod(methodName, txState.getTxParameterTypes());
		method.invoke(txState.getTxTarget(), txState.getTxParameterValues());
		txState.setTxState(TxState.COMMIT);
	}

	// ------------------------------------------------------------------------------------
	// doRollbackMethod
	// ------------------------------------------------------------------------------------

	private void doRollbackMethod(TxState txState)
			throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

		String methodName = txState.getDistributedTransaction().rollback();
		Method method = txState.getTxTarget().getClass().getMethod(methodName, txState.getTxParameterTypes());
		method.invoke(txState.getTxTarget(), txState.getTxParameterValues());
		txState.setTxState(TxState.ROLLBACK);
	}

	// ------------------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------------------

	private boolean isMasterDistributedTransaction(String methodId) {
		if(txStateTableThreadLocal.get().getMasterTxName().equals(methodId)) {
			return true;
		}
		return false;
	}
}
