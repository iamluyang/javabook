package online.javabook.design.gof.structural4.decorator.coffee.impl;

import online.javabook.design.gof.structural4.decorator.coffee.api.DecoratorCoffee;
import online.javabook.design.gof.structural4.decorator.coffee.api.ICoffee;

public class MilkCoffee extends DecoratorCoffee {

    public MilkCoffee() {
        super();
    }

    public MilkCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return super.getCup() + " + " + "Milk";
    }
}
