package org.gof.structural.patterns5.facde.app.mall.service.impl;

import org.gof.structural.patterns5.facde.app.mall.repository.api.ICartRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.api.IExpressRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.api.IPayRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.impl.CartRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.impl.ExpressRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.impl.PayRepository;
import org.gof.structural.patterns5.facde.app.mall.service.api.IOrderService;

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
