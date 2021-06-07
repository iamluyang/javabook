package online.javabook.gof.creational.patterns4.builder.car.director.api;

import online.javabook.gof.creational.patterns4.builder.car.builder.api.ICarBuilder;

public class CarDirector {

    private ICarBuilder carBuilder;

    public CarDirector(ICarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void construct() {
        carBuilder.buildFrame();
        carBuilder.buildEngine();
        carBuilder.buildWheel();
        carBuilder.buildComputer();
        carBuilder.buildNavigation();
    }
}
