package online.javabook.pattern.gof.creational.patterns4.builder.car.app.bad;

import online.javabook.pattern.gof.creational.patterns4.builder.car.product.components.Frame;
import online.javabook.pattern.gof.creational.patterns4.builder.car.product.components.*;
import online.javabook.pattern.gof.creational.patterns4.builder.car.product.main.Car;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        online.javabook.pattern.gof.creational.patterns4.builder.car.product.components.Frame frame = null;
        Engine engine = null;
        Wheel wheel = null;
        Computer computer = null;
        Navigation navigation = null;

        String type = "city";
        if(type.equals("city")) {
            frame = new online.javabook.pattern.gof.creational.patterns4.builder.car.product.components.Frame(Color.BLACK);
            engine = new Engine("oil");
            wheel = new Wheel(30);
            computer = new Computer("android");
            navigation = new Navigation("gps");

        }else if(type.equals("suv")) {
            frame = new online.javabook.pattern.gof.creational.patterns4.builder.car.product.components.Frame(Color.RED);
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
