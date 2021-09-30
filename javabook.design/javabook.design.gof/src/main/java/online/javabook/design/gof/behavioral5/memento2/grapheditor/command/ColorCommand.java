package online.javabook.design.gof.behavioral5.memento2.grapheditor.command;

import online.javabook.design.gof.behavioral5.memento2.grapheditor.context.Shape;

import java.awt.*;

public class ColorCommand implements IGraphCommand {

    private Color color;

    public ColorCommand(Color newColor) {
        this.color = newColor;
    }

    @Override
    public void execute(Shape shape) {
        shape.setColor(color);
    }
}
