package online.javabook.pattern.gof.creational.patterns4.builder.car.product.components;

public class Engine {

    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                '}';
    }
}
