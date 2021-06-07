package online.javabook.gof.creational.patterns4.builder.car.product.main;

import online.javabook.gof.creational.patterns4.builder.car.product.part.*;

public class Car {

    private Frame frame;

    private Engine engine;

    private Wheel wheel;

    private Navigation navigation;

    private Computer computer;

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "frame=" + frame +
                ", engine=" + engine +
                ", wheel=" + wheel +
                ", navigation=" + navigation +
                ", computer=" + computer +
                '}';
    }
}
