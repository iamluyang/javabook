package online.javabook.gof.structural.patterns4.decorator.coffee.impl;

import online.javabook.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import online.javabook.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class SaltCoffee extends DecoratorCoffee {

    public SaltCoffee() {
        super();
    }

    public SaltCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return super.getCup() + " + " + "Salt";
    }
}
