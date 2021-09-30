package online.javabook.design.gof.creational4.builder.car.product.part;

import java.awt.*;

public class Frame {

    private Color color;

    public Frame(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "color=" + color +
                '}';
    }
}
