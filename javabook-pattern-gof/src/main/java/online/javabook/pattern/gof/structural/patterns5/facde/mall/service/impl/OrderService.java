package online.javabook.pattern.gof.structural.patterns5.facde.mall.service.impl;

import online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.api.ICartRepository;
import online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.api.IExpressRepository;
import online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.api.IPayRepository;
import online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.impl.CartRepository;
import online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.impl.ExpressRepository;
import online.javabook.pattern.gof.structural.patterns5.facde.mall.repository.impl.PayRepository;
import online.javabook.pattern.gof.structural.patterns5.facde.mall.service.api.IOrderService;

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
