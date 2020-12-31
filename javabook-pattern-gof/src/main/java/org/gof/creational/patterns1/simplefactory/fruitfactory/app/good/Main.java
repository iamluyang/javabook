package org.gof.creational.patterns1.simplefactory.fruitfactory.app.good;

import org.gof.creational.patterns1.simplefactory.fruitfactory.consumer.FruitConsumer;
import org.gof.creational.patterns1.simplefactory.fruitfactory.creator.FruitEnum;
import org.gof.creational.patterns1.simplefactory.fruitfactory.creator.FruitFactory;

public class Main {
    public static void main(String[] args) {

        FruitConsumer fruitConsumer = new FruitConsumer();
        fruitConsumer.Buy( FruitFactory.getFruit(FruitEnum.Apple) );
        fruitConsumer.Buy( FruitFactory.getFruit(FruitEnum.Grape) );
        fruitConsumer.Buy( FruitFactory.getFruit(FruitEnum.Orange) );
    }
}
