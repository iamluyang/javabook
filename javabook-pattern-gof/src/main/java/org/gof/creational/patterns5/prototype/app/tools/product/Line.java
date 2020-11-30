package org.gof.creational.patterns5.prototype.app.tools.product;

import java.awt.*;
import java.io.*;

public class Line implements IFigurePrototype, Serializable, Cloneable {

    private int size = 1;

    private String color = Color.BLACK.toString();

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

    public Line shallowClone() throws CloneNotSupportedException {
        return (Line) clone();
    }

    public Line deepClone() throws IOException, ClassNotFoundException, CloneNotSupportedException {

        Line line = (Line) clone();

        // out
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(line);

        // in
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        line = (Line) ois.readObject();

        return line;
    }

}
