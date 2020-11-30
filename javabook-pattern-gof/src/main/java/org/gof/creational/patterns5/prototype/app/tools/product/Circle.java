package org.gof.creational.patterns5.prototype.app.tools.product;

import java.awt.*;
import java.io.*;

public class Circle implements IFigurePrototype, Serializable, Cloneable {

    private int size = 1;

    private int radius = 10;

    private String color = Color.BLACK.toString();

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle shallowClone() throws CloneNotSupportedException {
        return (Circle) clone();
    }
    public Circle deepClone() throws IOException, ClassNotFoundException, CloneNotSupportedException {

        Circle circle = (Circle) clone();

        // out
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(circle);

        // in
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        circle = (Circle) ois.readObject();

        return circle;
    }

}
