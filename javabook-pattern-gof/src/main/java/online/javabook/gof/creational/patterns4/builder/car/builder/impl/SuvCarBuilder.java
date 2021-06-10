package online.javabook.gof.creational.patterns4.builder.car.builder.impl;

import online.javabook.gof.creational.patterns4.builder.car.builder.api.ICarBuilder;
import online.javabook.gof.creational.patterns4.builder.car.product.main.Car;
import online.javabook.gof.creational.patterns4.builder.car.product.part.Frame;
import online.javabook.gof.creational.patterns4.builder.car.product.part.*;

import java.awt.*;

public class SuvCarBuilder implements ICarBuilder {

    private Car car = new Car();

    @Override
    public void buildFrame() {
        car.setFrame(new Frame(Color.RED));
    }

    @Override
    public void buildEngine() {
        car.setEngine(new Engine("oil"));
    }

    @Override
    public void buildWheel() {
        car.setWheel(new Wheel(30));
    }

    @Override
    public void buildNavigation() {
        car.setNavigation(new Navigation("beidou"));
    }

    @Override
    public void buildComputer() {
        car.setComputer(new Computer("ios"));
    }

    @Override
    public Car getCar() {
        return car;
    }
}
