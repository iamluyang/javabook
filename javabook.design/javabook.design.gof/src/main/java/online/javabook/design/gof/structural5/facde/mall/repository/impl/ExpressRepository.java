package online.javabook.design.gof.structural5.facde.mall.repository.impl;

import online.javabook.design.gof.structural5.facde.mall.repository.api.IExpressRepository;

public class ExpressRepository implements IExpressRepository {
    @Override
    public void ship() {
        System.out.println("ship.....");
    }
}
