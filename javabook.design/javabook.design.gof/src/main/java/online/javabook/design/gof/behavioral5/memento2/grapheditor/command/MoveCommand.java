package online.javabook.design.gof.behavioral5.memento2.grapheditor.command;

import online.javabook.design.gof.behavioral5.memento2.grapheditor.context.Shape;

import java.awt.*;

public class MoveCommand implements IGraphCommand {

    private Point point;

    public MoveCommand(Point newPoint) {
        this.point = newPoint;
    }

    @Override
    public void execute(Shape shape) {
        shape.setPoint(point);
    }
}
