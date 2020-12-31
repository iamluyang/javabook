package org.gof.structural.patterns5.facde.mall.service.impl;

import org.gof.structural.patterns5.facde.mall.repository.api.ICartRepository;
import org.gof.structural.patterns5.facde.mall.repository.api.IExpressRepository;
import org.gof.structural.patterns5.facde.mall.repository.api.IPayRepository;
import org.gof.structural.patterns5.facde.mall.repository.impl.CartRepository;
import org.gof.structural.patterns5.facde.mall.repository.impl.ExpressRepository;
import org.gof.structural.patterns5.facde.mall.repository.impl.PayRepository;
import org.gof.structural.patterns5.facde.mall.service.api.IOrderService;

public class OrderService implements IOrderService {

    private ICartRepository cartRepository = new CartRepository();

    private IPayRepository payRepository = new PayRepository();

    private IExpressRepository expressRepository = new ExpressRepository();

    @Override
    public void submitOrder() {
        cartRepository.buy();
        payRepository.pay();
        expressRepository.ship();
    }
}
