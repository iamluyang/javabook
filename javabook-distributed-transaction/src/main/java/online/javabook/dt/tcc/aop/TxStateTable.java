package online.javabook.dt.tcc.aop;

import online.javabook.dt.tcc.annotation.DistributedTransaction;

import java.util.HashMap;

public class TxStateTable {

    private String masterTxName;

    private long masterTxId;

    private long masterTxState;

    private HashMap<String, TxState> branchTxStates = new HashMap<String, TxState>(2);

    public TxStateTable(String masterTxName, long masterTxId, long masterTxState) {
        this.masterTxName = masterTxName;
        this.masterTxId = masterTxId;
        this.masterTxState = masterTxState;
    }

    public HashMap<String, TxState> getBranchTxStates() {
        return branchTxStates;
    }

    public String getMasterTxName() {
        return masterTxName;
    }

    public long getMasterTxId() {
        return masterTxId;
    }

    public long getMasterTxState() {
        return masterTxState;
    }

    public void setMasterTxState(long masterTxState) {
        this.masterTxState = masterTxState;
    }

    public TxState getBranchTxState(String branchMethodId) {
        return branchTxStates.get(branchMethodId);
    }

    public void setBranchTxState(String branchMethodId, short txState) {
        branchTxStates.get(branchMethodId).setTxState(txState);
    }

    public void addBranchTxState(String txName, long txId, short txStatus, Object txTarget, Class[] txParameterTypes, Object[] txParameterValues, DistributedTransaction distributedTransaction) {
        branchTxStates.put(txName, new TxState(txName, txId, txStatus, txTarget, txParameterTypes, txParameterValues, distributedTransaction));
    }

    public boolean isAllBranchTxPrepCommit() {
        for (TxState txState : branchTxStates.values()) {
            if(!txState.isPrepCommit()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnyBranchTxPrepRollBack() {
        for (TxState txState : branchTxStates.values()) {
            if(txState.isPrepRollback()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TxStateTable").append("\n");
        sb.append("{").append("\n");
        sb.append("masterTxId:").append(masterTxId).append(",\n");
        sb.append("masterTxName:").append(masterTxName).append(",\n");
        sb.append("masterTxState:").append(masterTxState).append("\n");

        sb.append("branchTxStates:[").append("\n");
        for (TxState txState : branchTxStates.values()) {
            sb.append(txState);
        }
        sb.append("\t]").append("\n");
        sb.append("}").append("\n");
        return sb.toString();
    }
}
