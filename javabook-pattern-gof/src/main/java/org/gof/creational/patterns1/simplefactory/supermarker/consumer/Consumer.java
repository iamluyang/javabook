package org.gof.creational.patterns1.simplefactory.supermarker.consumer;

import org.gof.creational.patterns1.simplefactory.supermarker.product.IFruit;

public class Consumer {

    public void Buy(IFruit fruit) {
        System.out.println(fruit);
    }
}
