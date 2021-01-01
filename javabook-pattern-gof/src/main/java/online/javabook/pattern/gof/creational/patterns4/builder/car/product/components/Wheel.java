package online.javabook.pattern.gof.creational.patterns4.builder.car.product.components;

public class Wheel {

    private int size;

    public Wheel(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "size=" + size +
                '}';
    }
}
