package online.javabook.design.gof.creational1.simplefactory.coffeefactory.customer;

import online.javabook.design.gof.creational1.simplefactory.coffeefactory.product.ICoffee;

public class CoffeeConsumer {

    public void buy(ICoffee coffee) {
        System.out.println(coffee);
    }
}