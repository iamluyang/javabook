package online.javabook.design.gof.structural4.decorator.coffee.impl;

import online.javabook.design.gof.structural4.decorator.coffee.api.DecoratorCoffee;
import online.javabook.design.gof.structural4.decorator.coffee.api.ICoffee;

public class SugarCoffee extends DecoratorCoffee {

    public SugarCoffee() {
        super();
    }

    public SugarCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return super.getCup() + " + " + "Sugar";
    }
}
