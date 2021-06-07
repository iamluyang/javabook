package online.javabook.gof.behavioral.patterns5.memento2.grapheditor.context;

import java.awt.*;

public class Shape {

    private Color color;

    private Point point = new Point(0, 0);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color=" + color +
                ", point=" + point +
                '}';
    }
}
