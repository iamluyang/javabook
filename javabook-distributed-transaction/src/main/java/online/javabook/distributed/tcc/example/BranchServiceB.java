package online.javabook.distributed.tcc.example;

import online.javabook.distributed.tcc.annotation.DistributedTransaction;
import online.javabook.distributed.tcc.annotation.BranchTxId;
import online.javabook.distributed.tcc.annotation.MasterTxId;
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
