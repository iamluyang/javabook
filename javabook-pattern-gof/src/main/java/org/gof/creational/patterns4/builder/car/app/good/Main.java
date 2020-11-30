package org.gof.creational.patterns4.builder.car.app.good;

import org.gof.creational.patterns4.builder.car.builder.api.ICarBuilder;
import org.gof.creational.patterns4.builder.car.builder.impl.CityCarBuilder;
import org.gof.creational.patterns4.builder.car.builder.impl.SportCarBuilder;
import org.gof.creational.patterns4.builder.car.builder.impl.SuvCarBuilder;
import org.gof.creational.patterns4.builder.car.director.api.CarDirector;
import org.gof.creational.patterns4.builder.car.product.Car;

public class Main {
    public static void main(String[] args) {

        ICarBuilder carBuilder = null;
        
        String type = "city";
        if(type.equals("city")) {
            carBuilder = new CityCarBuilder();

        }else if(type.equals("suv")) {
            carBuilder = new SuvCarBuilder();

        }else if(type.equals("city")) {
            carBuilder = new SportCarBuilder();
        }

        CarDirector carDirector = new CarDirector(carBuilder);
        carDirector.construct();
        Car car = carBuilder.getCar();
        System.out.println(car);
    }
}
