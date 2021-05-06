package online.javabook.distributed.tcc.example;

import online.javabook.distributed.tcc.annotation.BranchTxId;
import online.javabook.distributed.tcc.annotation.DistributedTransaction;
import online.javabook.distributed.tcc.annotation.MasterTxId;

public interface IBranchServiceB {

    @DistributedTransaction(name = "serviceB", commit = "doCommit", rollback = "doRollback")
    void doTry(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount);
}
