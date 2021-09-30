package online.javabook.design.gof.creational4.builder.car.product.part;

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
