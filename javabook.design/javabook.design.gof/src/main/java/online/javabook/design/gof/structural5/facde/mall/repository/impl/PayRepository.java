package online.javabook.design.gof.structural5.facde.mall.repository.impl;

import online.javabook.design.gof.structural5.facde.mall.repository.api.IPayRepository;

public class PayRepository implements IPayRepository {
    @Override
    public void pay() {
        System.out.println("pay.....");
    }
}
