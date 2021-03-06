package online.javabook.distributed.tcc.example;

import online.javabook.distributed.tcc.annotation.DistributedTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterService implements IMasterService {

    @Autowired
    private IBranchServiceA branchServiceA;

    @Autowired
    private IBranchServiceB branchServiceB;

    @DistributedTransaction
    public void doBusiness(int pk, int amount) {
        System.out.println("Begin:doTry");
        branchServiceA.doTry(0, 0, pk, amount);
        branchServiceB.doTry(0, 0, pk, amount);
        System.out.println("Commit/Rollback");
    }
}
