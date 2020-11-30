package org.gof.creational.patterns4.builder.car.product.components;

public class Navigation {

    private String gps;

    public Navigation(String gps) {
        this.gps = gps;
    }

    public String getGps() {
        return gps;
    }

    @Override
    public String toString() {
        return "Navigation{" +
                "gps='" + gps + '\'' +
                '}';
    }
}
