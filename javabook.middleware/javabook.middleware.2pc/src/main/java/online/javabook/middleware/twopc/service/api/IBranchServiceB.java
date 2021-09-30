package online.javabook.middleware.twopc.service.api;

import online.javabook.middleware.twopc.anno.DistributedTransaction;
import online.javabook.middleware.twopc.anno.MasterTxId;
import online.javabook.middleware.twopc.anno.BranchTxId;

public interface IBranchServiceB {

    @DistributedTransaction(name = "serviceB", commit = "doCommit", rollback = "doRollback")
    void doTry(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount);
}
