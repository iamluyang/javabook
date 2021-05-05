package online.javabook.dt.tcc.example;

import online.javabook.dt.tcc.annotation.DistributedTransaction;
import online.javabook.dt.tcc.annotation.BranchTxId;
import online.javabook.dt.tcc.annotation.MasterTxId;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceB implements IBranchServiceB {

    @DistributedTransaction(name = "serviceB", commit = "doCommit", rollback = "doRollback")
    public void doTry(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount) {
        System.out.println(this.getClass().getName()+".doTry(" + "@MasterTxId long " + mtxId + ", @BranchTxId long " + btxId + ", int pk " + pk + ", int amount " + amount + ")");
        throw new RuntimeException();
    }

    @Override
    public boolean doCommit(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount) {
        System.out.println(this.getClass().getName()+".doCommit(" + "@MasterTxId long " + mtxId + ", @BranchTxId long " + btxId + ", int amount " + amount + ")");
        return false;
    }

    @Override
    public boolean doRollback(@MasterTxId long mtxId, @BranchTxId long btxId, int pk, int amount) {
        System.out.println(this.getClass().getName()+".doRollback(" + "@MasterTxId long " + mtxId + ", @BranchTxId long " + btxId + ", int amount " + amount + ")");
        return false;
    }
}
