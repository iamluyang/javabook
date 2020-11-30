package org.gof.creational.patterns1.simplefactory.supermarker.app.good;

import org.gof.creational.patterns1.simplefactory.supermarker.consumer.Consumer;
import org.gof.creational.patterns1.simplefactory.supermarker.creator.FruitEnum;
import org.gof.creational.patterns1.simplefactory.supermarker.creator.FruitFactory;

public class Main {
    public static void main(String[] args) {

        Consumer consumer = new Consumer();
        consumer.Buy( FruitFactory.getFruit(FruitEnum.Apple) );
        consumer.Buy( FruitFactory.getFruit(FruitEnum.Grape) );
        consumer.Buy( FruitFactory.getFruit(FruitEnum.Orange) );
    }
}
