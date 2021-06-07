package online.javabook.gof.creational.patterns1.simplefactory.fruitfactory.customer;

import online.javabook.gof.creational.patterns1.simplefactory.fruitfactory.product.IFruit;

public class FruitConsumer {

    public void Buy(IFruit fruit) {
        System.out.println(fruit);
    }
}