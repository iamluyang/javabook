package online.javabook.design.gof.behavioral5.memento2.grapheditor.command;

import online.javabook.design.gof.behavioral5.memento2.grapheditor.context.Shape;

public interface IGraphCommand {
    void execute(Shape shape);
}
