package online.javabook.gof.structural.patterns5.facde.mall.app.bad;

import online.javabook.gof.structural.patterns5.facde.mall.repository.api.ICartRepository;
import online.javabook.gof.structural.patterns5.facde.mall.repository.api.IExpressRepository;
import online.javabook.gof.structural.patterns5.facde.mall.repository.api.IPayRepository;
import online.javabook.gof.structural.patterns5.facde.mall.repository.impl.CartRepository;
import online.javabook.gof.structural.patterns5.facde.mall.repository.impl.ExpressRepository;
import online.javabook.gof.structural.patterns5.facde.mall.repository.impl.PayRepository;

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
