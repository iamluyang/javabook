package online.javabook.middleware.twopc.service.impl;

import online.javabook.middleware.twopc.anno.DistributedTransaction;
import online.javabook.middleware.twopc.service.api.IBranchServiceA;
import online.javabook.middleware.twopc.service.api.IBranchServiceB;
import online.javabook.middleware.twopc.service.api.IMasterService;
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
