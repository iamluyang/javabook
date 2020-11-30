package org.gof.creational.patterns1.simplefactory.supermarker.creator;

import org.gof.creational.patterns1.simplefactory.supermarker.product.Apple;
import org.gof.creational.patterns1.simplefactory.supermarker.product.Grape;
import org.gof.creational.patterns1.simplefactory.supermarker.product.IFruit;
import org.gof.creational.patterns1.simplefactory.supermarker.product.Orange;

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
