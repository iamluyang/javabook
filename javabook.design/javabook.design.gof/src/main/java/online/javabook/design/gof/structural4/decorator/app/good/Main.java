package online.javabook.design.gof.structural4.decorator.app.good;

import online.javabook.design.gof.structural4.decorator.coffee.api.ICoffee;
import online.javabook.design.gof.structural4.decorator.coffee.impl.*;
import online.javabook.design.gof.structural4.decorator.coffee.impl.*;

public class Main {
    public static void main(String[] args) {

        String consumer = "consumer1";
        if (consumer.equals("consumer1")) {
            // coffee + sugar + milk + salt
            ICoffee coffee = new SaltCoffee(new MilkCoffee( new SugarCoffee( new SimpleCoffee())));
            System.out.println(coffee.getCup());

        } else if (consumer.equals("consumer2")) {
            // coffee + ice + salt + milk
            ICoffee coffee = new MilkCoffee(new SaltCoffee( new IceCoffee( new SimpleCoffee())));
            System.out.println(coffee.getCup());

        } else if (consumer.equals("consumer3")) {

            // coffee + sugar + sugar + milk
            ICoffee coffee = new MilkCoffee(new SugarCoffee( new SugarCoffee( new SimpleCoffee())));
            System.out.println(coffee.getCup());
        }
    }
}
