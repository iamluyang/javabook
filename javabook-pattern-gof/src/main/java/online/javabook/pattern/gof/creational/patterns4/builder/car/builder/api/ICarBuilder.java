package online.javabook.pattern.gof.creational.patterns4.builder.car.builder.api;

import online.javabook.pattern.gof.creational.patterns4.builder.car.product.main.Car;

public interface ICarBuilder {

    public void buildFrame();

    public void buildEngine();

    public void buildWheel();

    public void buildNavigation();

    public void buildComputer();

    public Car getCar();
}
