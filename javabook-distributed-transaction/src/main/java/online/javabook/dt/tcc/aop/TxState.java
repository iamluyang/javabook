package online.javabook.dt.tcc.aop;

import online.javabook.dt.tcc.annotation.DistributedTransaction;

public class TxState {

    public static short INIT = 0;
    public static short PREP_COMMIT = 1;
    public static short PREP_ROLLBACK = 2;
    public static short COMMIT = 3;
    public static short ROLLBACK = 4;

    private String txName;

    private long txId;

    private short txState;

    private Object txTarget;

    private Class[] txParameterTypes;

    private Object[] txParameterValues;

    private DistributedTransaction distributedTransaction;

    public TxState(String txName, long txId, short txState, Object txTarget, Class[] txParameterTypes, Object[] txParameterValues, DistributedTransaction dt) {
        this.txName = txName;
        this.txId = txId;
        this.txState = txState;
        this.txTarget = txTarget;
        this.txParameterTypes = txParameterTypes;
        this.txParameterValues = txParameterValues;
        this.distributedTransaction = dt;
    }

    public long getTxId() {
        return txId;
    }

    public void setTxId(long txId) {
        this.txId = txId;
    }

    public short getTxState() {
        return txState;
    }

    public void setTxState(short txState) {
        this.txState = txState;
    }

    public Object getTxTarget() {
        return txTarget;
    }

    public void setTxTarget(Object txTarget) {
        this.txTarget = txTarget;
    }

    public Class[] getTxParameterTypes() {
        return txParameterTypes;
    }

    public void setTxParameterTypes(Class[] txParameterTypes) {
        this.txParameterTypes = txParameterTypes;
    }

    public Object[] getTxParameterValues() {
        return txParameterValues;
    }

    public void setTxParameterValues(Object[] txParameterValues) {
        this.txParameterValues = txParameterValues;
    }

    public DistributedTransaction getDistributedTransaction() {
        return distributedTransaction;
    }

    public void setDistributedTransaction(DistributedTransaction distributedTransaction) {
        this.distributedTransaction = distributedTransaction;
    }

    boolean isPrepCommit() {
        return txState == PREP_COMMIT;
    }

    boolean isCommit() {
        return txState == COMMIT;
    }

    boolean isPrepRollback() {
        return txState == PREP_ROLLBACK;
    }

    boolean isRollback() {
        return txState == ROLLBACK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tTxState:").append("\n");
        sb.append("\t{").append("\n");
        sb.append("\t\ttxId:").append(txId).append(",\n");
        sb.append("\t\ttxState:").append(txState).append(",\n");
        sb.append("\t\ttxName:").append(txName).append("\n");
        sb.append("\t},").append("\n");

        return sb.toString();
    }
}
