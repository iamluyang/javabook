package org.gof.structural.patterns5.facde.mall.app.good;

import org.gof.structural.patterns5.facde.mall.service.api.IOrderService;
import org.gof.structural.patterns5.facde.mall.service.impl.OrderService;

public class Main {
    public static void main(String[] args) {

        IOrderService orderService = new OrderService();
        orderService.submitOrder();
    }
}
