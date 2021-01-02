package online.javabook.pattern.gof.creational.patterns1.simplefactory.fruitfactory.customer;

import online.javabook.pattern.gof.creational.patterns1.simplefactory.fruitfactory.product.IFruit;

public class FruitConsumer {

    public void Buy(IFruit fruit) {
        System.out.println(fruit);
    }
}