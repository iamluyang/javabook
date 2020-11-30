package org.gof.structural.patterns4.decorator.coffee.impl;

import org.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class Coffee extends DecoratorCoffee {

    public Coffee() {
        super();
    }

    public Coffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return "Coffee + " + super.getCup() + " ";
    }
}
