package online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.impl;

import online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.api.IExpressRepository;

public class ExpressRepository implements IExpressRepository {
    @Override
    public void ship() {
        System.out.println("ship.....");
    }
}
