package online.javabook.gof.structural.patterns4.decorator.coffee.impl;

import online.javabook.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import online.javabook.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class SimpleCoffee extends DecoratorCoffee {

    public SimpleCoffee() {
        super();
    }

    public SimpleCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return super.getCup() + " + " + "Coffee";
    }
}
