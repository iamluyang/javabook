package online.javabook.gof.creational.patterns4.builder.car.builder.impl;

import online.javabook.gof.creational.patterns4.builder.car.builder.api.ICarBuilder;
import online.javabook.gof.creational.patterns4.builder.car.product.part.Frame;
import online.javabook.gof.creational.patterns4.builder.car.product.part.*;
import online.javabook.gof.creational.patterns4.builder.car.product.main.Car;

import java.awt.*;

public class CityCarBuilder implements ICarBuilder {

    private Car car = new Car();

    @Override
    public void buildFrame() {
        car.setFrame(new Frame(Color.BLACK));
    }

    @Override
    public void buildEngine() {
        car.setEngine(new Engine("oil"));
    }

    @Override
    public void buildWheel() {
        car.setWheel(new Wheel(10));
    }

    @Override
    public void buildNavigation() {
        car.setNavigation(new Navigation("gps"));
    }

    @Override
    public void buildComputer() {
        car.setComputer(new Computer("android"));
    }

    @Override
    public Car getCar() {
        return car;
    }
}
