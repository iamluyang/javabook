package online.javabook.pattern.gof.creational.patterns4.builder.car.product.components;

public class Computer {

    private String os;

    public Computer(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "os='" + os + '\'' +
                '}';
    }
}
