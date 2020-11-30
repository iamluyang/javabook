package org.gof.creational.patterns5.prototype.app.good;

import org.gof.creational.patterns5.prototype.app.tools.manager.ToolPanel;
import org.gof.creational.patterns5.prototype.app.tools.product.Circle;
import org.gof.creational.patterns5.prototype.app.tools.product.Line;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // toolPanel
        ToolPanel toolPanel = new ToolPanel();

        // prototype
        Line prototypeLine = new Line();
        Circle prototypeCircle = new Circle();
        toolPanel.register(Line.class, prototypeLine);
        toolPanel.register(Circle.class, prototypeCircle);

        // clone
        Line newLine = (Line)toolPanel.shallowClone(Line.class);
        Circle newCircle = (Circle)toolPanel.deepClone(Circle.class);

        System.out.println("shallow prototype Line.size(" + prototypeLine.getSize() +") == new Line.size("+ newLine.getSize() +")? " + (prototypeLine.getSize() == newLine.getSize()));
        System.out.println("deep prototype Line.color("+prototypeLine.getColor()+") == new Line.color("+newLine.getColor()+")? " + (prototypeLine.getColor() == newLine.getColor()));

        System.out.println("deep prototype Circle.size == new Circle.size? " + (prototypeCircle.getSize() == newCircle.getSize()));
        System.out.println("deep prototype Circle.color("+prototypeCircle.getColor()+") == new Circle.color("+newCircle.getColor()+")? " + (prototypeCircle.getColor() == newCircle.getColor()));
    }
}
