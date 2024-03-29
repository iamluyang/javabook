package online.javabook.design.gof.creational5.prototype.graph.palette.product;

import java.awt.*;
import java.io.*;

public class LineGraphPrototype implements IGraphPrototype, Serializable, Cloneable {

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

    @Override
    public LineGraphPrototype shallowClone() throws CloneNotSupportedException {
        return (LineGraphPrototype) clone();
    }

    @Override
    public LineGraphPrototype deepClone() throws IOException, ClassNotFoundException, CloneNotSupportedException {

        LineGraphPrototype line = (LineGraphPrototype) clone();

        // out
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(line);

        // in
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        line = (LineGraphPrototype) ois.readObject();

        return line;
    }

}
