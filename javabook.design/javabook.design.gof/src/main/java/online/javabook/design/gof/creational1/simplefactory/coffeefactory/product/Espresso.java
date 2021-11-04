package online.javabook.design.gof.creational1.simplefactory.coffeefactory.product;

/**
 * https://en.wikipedia.org/wiki/Espresso
 */
public class Espresso implements ICoffee {

    public String coffee;

    public String sugar;

    public String milk;

    public Espresso() {

    }

    public Espresso configSugar(String arg1) {
        // TODO arg1
        return this;
    }

    public Espresso configMilk(String arg2) {
        // TODO arg2
        return this;
    }

    public Espresso configCoffee(String arg3) {
        // TODO arg3
        return this;
    }

    @Override
    public String toString() {
        return "I am Espresso";
    }
}
