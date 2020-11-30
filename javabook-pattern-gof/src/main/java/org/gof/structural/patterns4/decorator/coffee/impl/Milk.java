package org.gof.structural.patterns4.decorator.coffee.impl;

import org.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class Milk extends DecoratorCoffee {

    public Milk() {
        super();
    }

    public Milk(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        String currentBusiness = "Milk + ";
        String decoratedCoffee = super.getCup();
        return currentBusiness + decoratedCoffee;
    }
}
