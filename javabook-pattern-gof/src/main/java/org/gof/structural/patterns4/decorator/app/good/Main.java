package org.gof.structural.patterns4.decorator.app.good;

import org.gof.structural.patterns4.decorator.coffee.api.ICoffee;
import org.gof.structural.patterns4.decorator.coffee.impl.Coffee;
import org.gof.structural.patterns4.decorator.coffee.impl.Ice;
import org.gof.structural.patterns4.decorator.coffee.impl.Milk;
import org.gof.structural.patterns4.decorator.coffee.impl.Sugar;

public class Main {
    public static void main(String[] args) {

        // simpe coffee
        ICoffee coffee = new Coffee();
        System.out.println(coffee.getCup());

        // coffee + milk + ice + sugar
        ICoffee coffee1 = new Coffee(new Milk( new Ice( new Sugar())));
        System.out.println(coffee1.getCup());

        // milk + coffee + ice + sugar
        ICoffee coffee2 = new Milk(new Coffee( new Ice( new Sugar())));
        System.out.println(coffee2.getCup());

        // coffee + sugar + sugar + milk
        ICoffee coffee3 = new Coffee(new Sugar( new Sugar( new Milk())));
        System.out.println(coffee3.getCup());
    }
}
