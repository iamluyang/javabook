package org.gof.structural.patterns5.facde.app.good;

import org.gof.structural.patterns5.facde.app.mall.service.api.IOrderService;
import org.gof.structural.patterns5.facde.app.mall.service.impl.OrderService;

public class Main {
    public static void main(String[] args) {

        IOrderService orderService = new OrderService();
        orderService.submitOrder();
    }
}
