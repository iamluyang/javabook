package online.javabook.design.gof.creational1.simplefactory.fruitfactory.creator;

import online.javabook.design.gof.creational1.simplefactory.fruitfactory.product.Apple;
import online.javabook.design.gof.creational1.simplefactory.fruitfactory.product.Grape;
import online.javabook.design.gof.creational1.simplefactory.fruitfactory.product.IFruit;
import online.javabook.design.gof.creational1.simplefactory.fruitfactory.product.Orange;

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
