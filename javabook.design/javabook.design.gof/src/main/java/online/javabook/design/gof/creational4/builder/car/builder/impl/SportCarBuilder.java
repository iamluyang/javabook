package online.javabook.design.gof.creational4.builder.car.builder.impl;

import online.javabook.design.gof.creational4.builder.car.product.main.Car;
import online.javabook.design.gof.creational4.builder.car.product.part.*;
import online.javabook.design.gof.creational4.builder.car.product.part.Frame;
import online.javabook.design.gof.creational4.builder.car.builder.api.ICarBuilder;
import online.javabook.design.gof.creational4.builder.car.product.part.*;

import java.awt.*;

public class SportCarBuilder implements ICarBuilder {

    private Car car = new Car();

    @Override
    public void buildFrame() {
        car.setFrame(new Frame(Color.CYAN));
    }

    @Override
    public void buildEngine() {
        car.setEngine(new Engine("oil"));
    }

    @Override
    public void buildWheel() {
        car.setWheel(new Wheel(20));
    }

    @Override
    public void buildNavigation() {
        car.setNavigation(new Navigation("gps"));
    }

    @Override
    public void buildComputer() {
        car.setComputer(new Computer("windows"));
    }

    @Override
    public Car getCar() {
        return car;
    }
}
