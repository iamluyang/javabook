package online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.impl;

import online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.api.ICartRepository;

public class CartRepository implements ICartRepository {
    @Override
    public void buy() {
        System.out.println("buy.....");
    }
}
