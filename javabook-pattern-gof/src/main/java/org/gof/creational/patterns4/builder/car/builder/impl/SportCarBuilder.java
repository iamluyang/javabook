package org.gof.creational.patterns4.builder.car.builder.impl;

import org.gof.creational.patterns4.builder.car.builder.api.ICarBuilder;
import org.gof.creational.patterns4.builder.car.product.components.*;
import org.gof.creational.patterns4.builder.car.product.components.Frame;
import org.gof.creational.patterns4.builder.car.product.main.Car;

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
