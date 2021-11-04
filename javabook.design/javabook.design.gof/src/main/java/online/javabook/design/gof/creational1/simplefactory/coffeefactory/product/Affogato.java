package online.javabook.design.gof.creational1.simplefactory.coffeefactory.product;

/**
 * https://en.wikipedia.org/wiki/Affogato
 */
public class Affogato implements ICoffee {

    public String coffee;

    public String sugar;

    public String milk;

    public Affogato(String coffee, String sugar, String milk) {
        this.coffee = coffee;
        this.sugar = sugar;
        this.milk = milk;
    }

    @Override
    public String toString() {
        return "I am Affogato";
    }
}
