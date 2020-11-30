package org.gof.creational.patterns4.builder.car.app.bad;

import org.gof.creational.patterns4.builder.car.builder.api.ICarBuilder;
import org.gof.creational.patterns4.builder.car.builder.impl.CityCarBuilder;
import org.gof.creational.patterns4.builder.car.builder.impl.SportCarBuilder;
import org.gof.creational.patterns4.builder.car.builder.impl.SuvCarBuilder;
import org.gof.creational.patterns4.builder.car.director.api.CarDirector;
import org.gof.creational.patterns4.builder.car.product.Car;
import org.gof.creational.patterns4.builder.car.product.components.*;
import org.gof.creational.patterns4.builder.car.product.components.Frame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Frame frame = null;
        Engine engine = null;
        Wheel wheel = null;
        Computer computer = null;
        Navigation navigation = null;

        String type = "city";
        if(type.equals("city")) {
            frame = new Frame(Color.BLACK);
            engine = new Engine("oil");
            wheel = new Wheel(30);
            computer = new Computer("android");
            navigation = new Navigation("gps");

        }else if(type.equals("suv")) {
            frame = new Frame(Color.RED);
            engine = new Engine("oil");
            wheel = new Wheel(20);
            computer = new Computer("ios");
            navigation = new Navigation("gps");

        }else if(type.equals("city")) {
            frame = new Frame(Color.CYAN);
            engine = new Engine("oil");
            wheel = new Wheel(30);
            computer = new Computer("windows");
            navigation = new Navigation("beidou");

        }

        Car car = new Car();
        car.setFrame(frame);
        car.setEngine(engine);
        car.setWheel(wheel);
        car.setComputer(computer);
        car.setNavigation(navigation);

        System.out.println(car);
    }
}
