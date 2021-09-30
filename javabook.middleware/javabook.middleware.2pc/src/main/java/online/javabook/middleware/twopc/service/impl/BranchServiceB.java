package online.javabook.middleware.twopc.service.impl;

import online.javabook.middleware.twopc.anno.BranchTxId;
import online.javabook.middleware.twopc.anno.DistributedTransaction;
import online.javabook.middleware.twopc.anno.MasterTxId;
import online.javabook.middleware.twopc.service.api.IBranchServiceB;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceB implements IBranchServiceB {

    @DistributedTransaction(name = "serviceB", commit = "doCommit", rollback = "doRollback")
    public void doTry(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount) {
        System.out.println(this.getClass().getName()+".doTry(" + "@MasterTxId long " + mtxId + ", @BranchTxId long " + btxId + ", int pk " + pk + ", int amount " + amount + ")");
        //throw new RuntimeException();
    }

    private boolean doCommit(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount) {
        System.out.println(this.getClass().getName()+".doCommit(" + "@MasterTxId long " + mtxId + ", @BranchTxId long " + btxId + ", int amount " + amount + ")");
        return false;
    }

    private boolean doRollback(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount) {
        System.out.println(this.getClass().getName()+".doRollback(" + "@MasterTxId long " + mtxId + ", @BranchTxId long " + btxId + ", int amount " + amount + ")");
        return false;
    }
}
