package online.javabook.dt.tcc.example;

import online.javabook.dt.tcc.annotation.BranchTxId;
import online.javabook.dt.tcc.annotation.DistributedTransaction;
import online.javabook.dt.tcc.annotation.MasterTxId;

public interface IBranchServiceA {

    @DistributedTransaction(name = "serviceA", commit = "doCommit", rollback = "doRollback")
    void doTry(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount);
}
