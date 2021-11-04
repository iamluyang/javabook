package online.javabook.design.gof.creational1.simplefactory.coffeefactory.app.bad;

import online.javabook.design.gof.creational1.simplefactory.coffeefactory.customer.CoffeeConsumer;
import online.javabook.design.gof.creational1.simplefactory.coffeefactory.product.*;

public class Main {
    public static void main(String[] args) {

        CoffeeConsumer coffeeConsumer = new CoffeeConsumer();
        coffeeConsumer.buy(new Affogato("coffee1", "sugar1", "milk1"));
        coffeeConsumer.buy(new Bicerin("coffee2", "sugar2", "milk2"));
        coffeeConsumer.buy(new Cappuccino("coffee3", "sugar3", "milk3"));
        coffeeConsumer.buy(new Doppio("coffee4", "sugar4", "milk4"));
        coffeeConsumer.buy(new Espresso()
                .configSugar("coffee5")
                .configMilk("sugar5")
                .configCoffee("milk5"));
    }
}
