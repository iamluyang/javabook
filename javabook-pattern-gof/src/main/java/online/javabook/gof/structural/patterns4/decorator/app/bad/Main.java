package online.javabook.gof.structural.patterns4.decorator.app.bad;

import online.javabook.gof.structural.patterns4.decorator.coffee.impl.MilkCoffee;
import online.javabook.gof.structural.patterns4.decorator.coffee.impl.SaltCoffee;
import online.javabook.gof.structural.patterns4.decorator.coffee.impl.SimpleCoffee;
import online.javabook.gof.structural.patterns4.decorator.coffee.impl.SugarCoffee;

public class Main {
    public static void main(String[] args) {

        String consumer = "consumer1";
        if (consumer.equals("consumer1")) {
            String coffee =
                    new SimpleCoffee().getCup() +
                            new SugarCoffee().getCup() +
                            new MilkCoffee().getCup() +
                            new SaltCoffee().getCup();
            System.out.println(coffee);

        } else if (consumer.equals("consumer2")) {
            String coffee =
                    new SaltCoffee().getCup() +
                            new SaltCoffee().getCup() +
                            new SimpleCoffee().getCup() +
                            new SugarCoffee().getCup();
            System.out.println(coffee);

        } else if (consumer.equals("consumer3")) {
            String coffee =
                    new SimpleCoffee().getCup() +
                            new SugarCoffee().getCup() +
                            new SugarCoffee().getCup() +
                            new SaltCoffee().getCup();
            System.out.println(coffee);
        }
    }
}
