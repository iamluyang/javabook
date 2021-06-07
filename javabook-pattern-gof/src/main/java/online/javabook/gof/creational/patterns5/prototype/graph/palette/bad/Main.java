package online.javabook.gof.creational.patterns5.prototype.graph.palette.bad;

import online.javabook.gof.creational.patterns5.prototype.graph.palette.product.LineGraphPrototype;

public class Main {
    public static void main(String[] args) {
        LineGraphPrototype lineGraphPrototype = new LineGraphPrototype();
        LineGraphPrototype newLineGraph = new LineGraphPrototype();
        newLineGraph.setSize(lineGraphPrototype.getSize());
        newLineGraph.setColor(lineGraphPrototype.getColor());

        System.out.println("lineGraphPrototype.getSize() -> " + lineGraphPrototype.getSize() + " == shallowCloneLineGraph.getSize() -> " + newLineGraph.getSize() + " ? " + (lineGraphPrototype.getSize() == newLineGraph.getSize()));
        System.out.println("lineGraphPrototype.getColor() -> " + lineGraphPrototype.getColor() + " == shallowCloneLineGraph.getColor() -> " + newLineGraph.getColor() + " ? " + (lineGraphPrototype.getColor() == newLineGraph.getColor()));

    }
}
