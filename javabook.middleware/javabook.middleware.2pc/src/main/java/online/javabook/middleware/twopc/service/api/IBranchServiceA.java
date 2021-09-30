package online.javabook.middleware.twopc.service.api;

import online.javabook.middleware.twopc.anno.DistributedTransaction;
import online.javabook.middleware.twopc.anno.MasterTxId;
import online.javabook.middleware.twopc.anno.BranchTxId;

public interface IBranchServiceA {

    @DistributedTransaction(name = "serviceA", commit = "doCommit", rollback = "doRollback")
    void doTry(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount);
}
