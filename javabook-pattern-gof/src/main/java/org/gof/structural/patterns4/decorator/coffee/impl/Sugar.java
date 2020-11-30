package org.gof.structural.patterns4.decorator.coffee.impl;

import org.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class Sugar extends DecoratorCoffee {

    public Sugar() {
        super();
    }

    public Sugar(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return "Sugar + " + super.getCup() + " ";
    }
}
