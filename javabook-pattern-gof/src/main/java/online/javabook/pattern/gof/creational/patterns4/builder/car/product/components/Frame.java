package online.javabook.pattern.gof.creational.patterns4.builder.car.product.components;

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
