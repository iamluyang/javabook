package online.javabook.design.gof.creational1.simplefactory.fruitfactory.customer;

import online.javabook.design.gof.creational1.simplefactory.fruitfactory.product.IFruit;

public class FruitConsumer {

    public void Buy(IFruit fruit) {
        System.out.println(fruit);
    }
}