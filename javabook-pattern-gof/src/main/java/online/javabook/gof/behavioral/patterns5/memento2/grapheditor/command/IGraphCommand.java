package online.javabook.gof.behavioral.patterns5.memento2.grapheditor.command;

import online.javabook.gof.behavioral.patterns5.memento2.grapheditor.context.Shape;

public interface IGraphCommand {
    void execute(Shape shape);
}
