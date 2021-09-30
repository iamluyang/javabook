package online.javabook.design.gof.structural5.facde.mall.repository.impl;

import online.javabook.design.gof.structural5.facde.mall.repository.api.ICartRepository;

public class CartRepository implements ICartRepository {
    @Override
    public void buy() {
        System.out.println("buy.....");
    }
}
