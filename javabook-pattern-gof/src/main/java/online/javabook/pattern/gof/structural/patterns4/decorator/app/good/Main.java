package online.javabook.pattern.gof.structural.patterns4.decorator.app.good;

import online.javabook.pattern.gof.structural.patterns4.decorator.coffee.api.ICoffee;
import online.javabook.pattern.gof.structural.patterns4.decorator.coffee.impl.IceCoffee;
import online.javabook.pattern.gof.structural.patterns4.decorator.coffee.impl.MilkCoffee;
import online.javabook.pattern.gof.structural.patterns4.decorator.coffee.impl.SimpleCoffee;
import online.javabook.pattern.gof.structural.patterns4.decorator.coffee.impl.SugarCoffee;

public class Main {
    public static void main(String[] args) {

        String consumer = "consumer1";
        if (consumer.equals("consumer1")) {
            // coffee + milk + ice + sugar
            ICoffee coffee = new SimpleCoffee(new MilkCoffee( new IceCoffee( new SugarCoffee())));
            System.out.println(coffee.getCup());

        } else if (consumer.equals("consumer2")) {
            // milk + coffee + ice + sugar
            ICoffee coffee = new MilkCoffee(new SimpleCoffee( new IceCoffee( new SugarCoffee())));
            System.out.println(coffee.getCup());

        } else if (consumer.equals("consumer3")) {

            // coffee + sugar + sugar + milk
            ICoffee coffee = new SimpleCoffee(new SugarCoffee( new SugarCoffee( new MilkCoffee())));
            System.out.println(coffee.getCup());
        }
    }
}
