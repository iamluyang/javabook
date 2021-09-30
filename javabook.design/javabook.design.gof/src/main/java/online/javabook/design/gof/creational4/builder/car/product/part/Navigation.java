package online.javabook.design.gof.creational4.builder.car.product.part;

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
