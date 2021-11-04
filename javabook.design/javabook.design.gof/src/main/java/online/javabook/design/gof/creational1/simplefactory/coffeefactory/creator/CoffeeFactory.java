package online.javabook.design.gof.creational1.simplefactory.coffeefactory.creator;

import online.javabook.design.gof.creational1.simplefactory.coffeefactory.product.*;

/**
 * CoffeeFactory
 */
public class CoffeeFactory {

    public static ICoffee getCoffee(CoffeeMenu coffeeEnum) {

        if (CoffeeMenu.Affogato.equals(coffeeEnum)) {
            return new Affogato("coffee", "sugar", "milk");

        } else if (CoffeeMenu.Bicerin.equals(coffeeEnum)) {
            return new Bicerin("coffee", "sugar", "milk");

        } else if (CoffeeMenu.Cappuccino.equals(coffeeEnum)) {
            return new Cappuccino("coffee", "sugar", "milk");

        } else if (CoffeeMenu.Doppio.equals(coffeeEnum)) {
            return new Doppio("coffee", "sugar", "milk");

        } else if (CoffeeMenu.Espresso.equals(coffeeEnum)) {
            return new Espresso()
                    .configCoffee("coffee")
                    .configSugar("sugar")
                    .configMilk("milk");
        } else
            return null;
    }
}
