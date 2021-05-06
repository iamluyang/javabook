package online.javabook.pattern.gof.structural.patterns5.facde.mall.app.good;

import online.javabook.pattern.gof.structural.patterns5.facde.mall.service.api.IOrderService;
import online.javabook.pattern.gof.structural.patterns5.facde.mall.service.impl.OrderService;

public class Main {
    public static void main(String[] args) {

        IOrderService orderService = new OrderService();
        orderService.submitOrder();
    }
}
