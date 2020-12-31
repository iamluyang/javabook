package org.gof.structural.patterns4.decorator.coffee.impl;

import org.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class SaltCoffee extends DecoratorCoffee {

    public SaltCoffee() {
        super();
    }

    public SaltCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return "Salt + " + super.getCup() + " ";
    }
}
