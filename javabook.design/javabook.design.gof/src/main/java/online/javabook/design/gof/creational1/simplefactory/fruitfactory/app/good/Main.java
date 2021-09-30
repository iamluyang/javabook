package online.javabook.design.gof.creational1.simplefactory.fruitfactory.app.good;

import online.javabook.design.gof.creational1.simplefactory.fruitfactory.customer.FruitConsumer;
import online.javabook.design.gof.creational1.simplefactory.fruitfactory.creator.FruitEnum;
import online.javabook.design.gof.creational1.simplefactory.fruitfactory.creator.FruitFactory;

public class Main {
    public static void main(String[] args) {

        FruitConsumer fruitConsumer = new FruitConsumer();
        fruitConsumer.Buy( FruitFactory.getFruit(FruitEnum.Apple) );
        fruitConsumer.Buy( FruitFactory.getFruit(FruitEnum.Grape) );
        fruitConsumer.Buy( FruitFactory.getFruit(FruitEnum.Orange) );
    }
}
