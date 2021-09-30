package online.javabook.design.gof.structural5.facde.mall.app.good;

import online.javabook.design.gof.structural5.facde.mall.service.impl.OrderService;
import online.javabook.design.gof.structural5.facde.mall.service.api.IOrderService;

public class Main {
    public static void main(String[] args) {

        IOrderService orderService = new OrderService();
        orderService.submitOrder();
    }
}
