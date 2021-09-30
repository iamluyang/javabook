package online.javabook.design.gof.creational1.simplefactory.fruitfactory.app.bad;

import online.javabook.design.gof.creational1.simplefactory.fruitfactory.customer.FruitConsumer;
import online.javabook.design.gof.creational1.simplefactory.fruitfactory.product.Apple;
import online.javabook.design.gof.creational1.simplefactory.fruitfactory.product.Grape;
import online.javabook.design.gof.creational1.simplefactory.fruitfactory.product.Orange;

public class Main {
    public static void main(String[] args) {

        FruitConsumer fruitConsumer = new FruitConsumer();
        fruitConsumer.Buy(new Apple());
        fruitConsumer.Buy(new Grape());
        fruitConsumer.Buy(new Orange());
    }
}
