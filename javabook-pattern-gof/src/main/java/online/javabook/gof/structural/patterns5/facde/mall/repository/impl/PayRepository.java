package online.javabook.gof.structural.patterns5.facde.mall.repository.impl;

import online.javabook.gof.structural.patterns5.facde.mall.repository.api.IPayRepository;

public class PayRepository implements IPayRepository {
    @Override
    public void pay() {
        System.out.println("pay.....");
    }
}
