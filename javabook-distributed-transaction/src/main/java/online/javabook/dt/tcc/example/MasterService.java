package online.javabook.dt.tcc.example;

import online.javabook.dt.tcc.annotation.DistributedTransaction;
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
        branchServiceA.doBusiness(0, 0, pk, amount);
        branchServiceB.doBusiness(0, 0, pk, amount);
    }
}
