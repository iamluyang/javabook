package org.gof.structural.patterns4.decorator.coffee.impl;

import org.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class IceCoffee extends DecoratorCoffee {

    public IceCoffee() {
        super();
    }

    public IceCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return "Ice + " + super.getCup() + " ";
    }
}
