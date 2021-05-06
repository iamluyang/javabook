package online.javabook.pattern.gof.creational.patterns5.prototype.graph.palette.product;

import java.awt.*;
import java.io.*;

public class CircleGraphPrototype implements IGraphPrototype, Serializable, Cloneable {

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

    @Override
    public CircleGraphPrototype shallowClone() throws CloneNotSupportedException {
        return (CircleGraphPrototype) clone();
    }

    @Override
    public CircleGraphPrototype deepClone() throws IOException, ClassNotFoundException, CloneNotSupportedException {

        CircleGraphPrototype circle = (CircleGraphPrototype) clone();

        // out
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(circle);

        // in
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        circle = (CircleGraphPrototype) ois.readObject();

        return circle;
    }

}
