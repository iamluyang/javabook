package online.javabook.design.gof.structural4.decorator.coffee.impl;

import online.javabook.design.gof.structural4.decorator.coffee.api.DecoratorCoffee;
import online.javabook.design.gof.structural4.decorator.coffee.api.ICoffee;

public class IceCoffee extends DecoratorCoffee {

    public IceCoffee() {
        super();
    }

    public IceCoffee(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getCup() {
        return super.getCup() + " + " + "Ice";
    }
}
