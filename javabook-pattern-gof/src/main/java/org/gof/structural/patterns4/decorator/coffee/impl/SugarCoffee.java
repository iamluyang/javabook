package org.gof.structural.patterns4.decorator.coffee.impl;

import org.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class SugarCoffee extends DecoratorCoffee {

    public SugarCoffee() {
        super();
    }

    public SugarCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return "Sugar + " + super.getCup() + " ";
    }
}
