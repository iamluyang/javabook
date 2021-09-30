package online.javabook.design.gof.creational4.builder.car.director.api;

import online.javabook.design.gof.creational4.builder.car.builder.api.ICarBuilder;

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
