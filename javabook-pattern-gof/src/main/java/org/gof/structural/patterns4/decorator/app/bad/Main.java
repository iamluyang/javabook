package org.gof.structural.patterns4.decorator.app.bad;

import org.gof.structural.patterns4.decorator.coffee.impl.Coffee;
import org.gof.structural.patterns4.decorator.coffee.impl.Milk;
import org.gof.structural.patterns4.decorator.coffee.impl.Salt;
import org.gof.structural.patterns4.decorator.coffee.impl.Sugar;

public class Main {
    public static void main(String[] args) {

        String consumer = "consumer1";
        if (consumer.equals("consumer1")) {
            String coffee =
                    new Coffee().getCup() +
                    new Sugar().getCup() +
                    new Milk().getCup() +
                    new Salt().getCup();
            System.out.println(coffee);

        } else if (consumer.equals("consumer2")) {
            String coffee =
                    new Salt().getCup() +
                    new Salt().getCup() +
                    new Coffee().getCup() +
                    new Sugar().getCup();
            System.out.println(coffee);

        } else if (consumer.equals("consumer3")) {
            String coffee =
                    new Coffee().getCup() +
                    new Sugar().getCup() +
                    new Sugar().getCup() +
                    new Salt().getCup();
            System.out.println(coffee);
        }
    }
}
