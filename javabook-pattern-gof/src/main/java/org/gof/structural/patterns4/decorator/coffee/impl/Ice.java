package org.gof.structural.patterns4.decorator.coffee.impl;

import org.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class Ice extends DecoratorCoffee {

    public Ice() {
        super();
    }

    public Ice(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return "Ice + " + super.getCup() + " ";
    }
}
