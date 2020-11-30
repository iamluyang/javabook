package org.gof.creational.patterns4.builder.car.builder.api;

import org.gof.creational.patterns4.builder.car.product.Car;

public interface ICarBuilder {

    public void buildFrame();

    public void buildEngine();

    public void buildWheel();

    public void buildNavigation();

    public void buildComputer();

    public Car getCar();
}
