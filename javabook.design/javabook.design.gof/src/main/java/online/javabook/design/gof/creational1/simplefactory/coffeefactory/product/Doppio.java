package online.javabook.design.gof.creational1.simplefactory.coffeefactory.product;

/**
 * https://en.wikipedia.org/wiki/Doppio
 */
public class Doppio implements ICoffee {

    public String coffee;

    public String sugar;

    public String milk;

    public Doppio(String coffee, String sugar, String milk) {
        this.coffee = coffee;
        this.sugar = sugar;
        this.milk = milk;
    }

    @Override
    public String toString() {
        return "I am Doppio";
    }
}
