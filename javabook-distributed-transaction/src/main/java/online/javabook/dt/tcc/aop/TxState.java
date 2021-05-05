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

    private Class[] txArgTypes;

    private Object[] txArgValues;

    private Exception txException;

    private DistributedTransaction distributedTransaction;

    public TxState(String txName, long txId, short txState, Object txTarget, Class[] txArgTypes, Object[] txArgValues, DistributedTransaction dt) {
        this.txName = txName;
        this.txId = txId;
        this.txState = txState;
        this.txTarget = txTarget;
        this.txArgTypes = txArgTypes;
        this.txArgValues = txArgValues;
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

    public Class[] getTxArgTypes() {
        return txArgTypes;
    }

    public void setTxArgTypes(Class[] txArgTypes) {
        this.txArgTypes = txArgTypes;
    }

    public Object[] getTxArgValues() {
        return txArgValues;
    }

    public void setTxArgValues(Object[] txArgValues) {
        this.txArgValues = txArgValues;
    }

    public Exception getTxException() {
        return txException;
    }

    public void setTxException(Exception txException) {
        this.txException = txException;
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
