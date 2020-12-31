package org.gof.structural.patterns4.decorator.coffee.impl;

import org.gof.structural.patterns4.decorator.coffee.api.DecoratorCoffee;
import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;

public class MilkCoffee extends DecoratorCoffee {

    public MilkCoffee() {
        super();
    }

    public MilkCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return "Milk + " + super.getCup() + " ";
    }
}
