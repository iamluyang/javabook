package org.gof.structural.patterns5.facde.app.bad;

import org.gof.structural.patterns5.facde.app.mall.repository.api.ICartRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.api.IExpressRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.api.IPayRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.impl.CartRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.impl.ExpressRepository;
import org.gof.structural.patterns5.facde.app.mall.repository.impl.PayRepository;

public class Main {
    public static void main(String[] args) {

        ICartRepository cartRepository = new CartRepository();
        IPayRepository payRepository = new PayRepository();
        IExpressRepository expressRepository = new ExpressRepository();

        cartRepository.buy();
        payRepository.pay();
        expressRepository.ship();
    }
}
