package org.gof.structural.patterns5.facde.app.mall.repository.impl;

import org.gof.structural.patterns5.facde.app.mall.repository.api.IPayRepository;

public class PayRepository implements IPayRepository {
    @Override
    public void pay() {
        System.out.println("pay.....");
    }
}
