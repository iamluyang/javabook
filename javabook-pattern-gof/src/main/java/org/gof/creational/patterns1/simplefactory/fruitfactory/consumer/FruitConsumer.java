package org.gof.creational.patterns1.simplefactory.fruitfactory.consumer;

import org.gof.creational.patterns1.simplefactory.fruitfactory.product.IFruit;

public class FruitConsumer {

    public void Buy(IFruit fruit) {
        System.out.println(fruit);
    }
}
