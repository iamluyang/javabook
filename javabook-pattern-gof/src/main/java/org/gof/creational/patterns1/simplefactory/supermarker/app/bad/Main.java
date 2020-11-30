package org.gof.creational.patterns1.simplefactory.supermarker.app.bad;

import org.gof.creational.patterns1.simplefactory.supermarker.consumer.Consumer;
import org.gof.creational.patterns1.simplefactory.supermarker.product.Apple;
import org.gof.creational.patterns1.simplefactory.supermarker.product.Grape;
import org.gof.creational.patterns1.simplefactory.supermarker.product.Orange;

public class Main {
    public static void main(String[] args) {

        Consumer consumer = new Consumer();
        consumer.Buy(new Apple());
        consumer.Buy(new Grape());
        consumer.Buy(new Orange());
    }
}
