package online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.command;

import online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.context.Shape;

public interface IGraphCommand {
    void execute(Shape shape);
}
