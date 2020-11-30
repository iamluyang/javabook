package org.gof.structural.patterns5.facde.app.mall.repository.impl;

import org.gof.structural.patterns5.facde.app.mall.repository.api.IExpressRepository;

public class ExpressRepository implements IExpressRepository {
    @Override
    public void ship() {
        System.out.println("ship.....");
    }
}
