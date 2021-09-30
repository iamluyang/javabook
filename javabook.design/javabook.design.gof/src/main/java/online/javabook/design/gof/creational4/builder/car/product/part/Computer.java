package online.javabook.design.gof.creational4.builder.car.product.part;

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
