package org.gof.creational.patterns1.simplefactory.fruitfactory.creator;

import org.gof.creational.patterns1.simplefactory.fruitfactory.product.Apple;
import org.gof.creational.patterns1.simplefactory.fruitfactory.product.Grape;
import org.gof.creational.patterns1.simplefactory.fruitfactory.product.IFruit;
import org.gof.creational.patterns1.simplefactory.fruitfactory.product.Orange;

// Supermarket
public class FruitFactory {

    public static IFruit getFruit(FruitEnum fruit){

        if(FruitEnum.Apple.equals(fruit)){
            return new Apple();

        }else if(FruitEnum.Orange.equals(fruit)){
            return new Orange();

        }else if(FruitEnum.Grape.equals(fruit)){
            return new Grape();
        }
        else
            return null;
    }
}
