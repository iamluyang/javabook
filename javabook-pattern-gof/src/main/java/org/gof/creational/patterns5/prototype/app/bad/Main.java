package org.gof.creational.patterns5.prototype.app.bad;

import org.gof.creational.patterns5.prototype.app.tools.product.Line;

public class Main {
    public static void main(String[] args) {
        Line prototypeLine = new Line();
        Line newLine = new Line();
        newLine.setSize(prototypeLine.getSize());
        newLine.setColor(prototypeLine.getColor());

        System.out.println("shallow prototype Line.size == new Line.size? " + (prototypeLine.getSize() == newLine.getSize()));
        System.out.println("shallow prototype Line.color == new Line.color? " + (prototypeLine.getColor() == newLine.getColor()));
    }
}
