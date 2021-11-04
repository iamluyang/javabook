package online.javabook.design.gof.creational1.simplefactory.coffeefactory.app.good;

import online.javabook.design.gof.creational1.simplefactory.coffeefactory.creator.CoffeeFactory;
import online.javabook.design.gof.creational1.simplefactory.coffeefactory.creator.CoffeeMenu;
import online.javabook.design.gof.creational1.simplefactory.coffeefactory.customer.CoffeeConsumer;

public class CoffeeShopMain {
    public static void main(String[] args) {
        CoffeeConsumer coffeeConsumer = new CoffeeConsumer();
        coffeeConsumer.buy(CoffeeFactory.getCoffee(CoffeeMenu.Affogato));
        coffeeConsumer.buy(CoffeeFactory.getCoffee(CoffeeMenu.Bicerin));
        coffeeConsumer.buy(CoffeeFactory.getCoffee(CoffeeMenu.Cappuccino));
        coffeeConsumer.buy(CoffeeFactory.getCoffee(CoffeeMenu.Doppio));
        coffeeConsumer.buy(CoffeeFactory.getCoffee(CoffeeMenu.Espresso));
    }
}
