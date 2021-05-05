package online.javabook.dt.tcc.example;

import online.javabook.dt.tcc.annotation.BranchTxId;
import online.javabook.dt.tcc.annotation.DistributedTransaction;
import online.javabook.dt.tcc.annotation.MasterTxId;

public interface IBranchServiceB {

    @DistributedTransaction(name = "serviceB", commit = "doCommit", rollback = "doRollback")
    void doTry(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount);

    boolean doCommit(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount);

    boolean doRollback(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount);
}
