package org.gof.creational.patterns5.prototype.graph.palette.good;

import org.gof.creational.patterns5.prototype.graph.palette.manager.GraphPrototypeManager;
import org.gof.creational.patterns5.prototype.graph.palette.product.CircleGraphPrototype;
import org.gof.creational.patterns5.prototype.graph.palette.product.LineGraphPrototype;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // prototype manager
        GraphPrototypeManager graphPrototypeManager = new GraphPrototypeManager();

        // prototype register
        LineGraphPrototype lineGraphPrototype = new LineGraphPrototype();
        CircleGraphPrototype circleGraphPrototype = new CircleGraphPrototype();
        graphPrototypeManager.register(LineGraphPrototype.class, lineGraphPrototype);
        graphPrototypeManager.register(CircleGraphPrototype.class, circleGraphPrototype);

        // shallow clone
        System.out.println("shallow clone:");

        LineGraphPrototype shallowCloneLineGraph = (LineGraphPrototype)graphPrototypeManager.shallowClone(LineGraphPrototype.class);

        System.out.println("shallow lineGraphPrototype.getSize() -> " + lineGraphPrototype.getSize() + " == shallowCloneLineGraph.getSize() -> " + shallowCloneLineGraph.getSize() + " ? " + (lineGraphPrototype.getSize() == shallowCloneLineGraph.getSize()));
        System.out.println("shallow lineGraphPrototype.getColor() -> " + lineGraphPrototype.getColor() + " == shallowCloneLineGraph.getColor() -> " + shallowCloneLineGraph.getColor() + " ? " + (lineGraphPrototype.getColor() == shallowCloneLineGraph.getColor()));

        // deep clone
        System.out.println("deep clone:");

        LineGraphPrototype deepCloneLineGraph = (LineGraphPrototype)graphPrototypeManager.deepClone(LineGraphPrototype.class);

        System.out.println("deep lineGraphPrototype.getSize() -> " + lineGraphPrototype.getSize() + " == deepCloneLineGraph.getSize() -> " + deepCloneLineGraph.getSize() + " ? " + (lineGraphPrototype.getSize() == deepCloneLineGraph.getSize()));
        System.out.println("deep lineGraphPrototype.getColor() -> " + lineGraphPrototype.getColor() + " == deepCloneLineGraph.getColor() -> " + deepCloneLineGraph.getColor() + " ? " + (lineGraphPrototype.getColor() == deepCloneLineGraph.getColor()));

    }
}
