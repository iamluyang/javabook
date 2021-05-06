package online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.context;

import online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.command.ColorCommand;
import online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.command.IGraphCommand;
import online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.command.MoveCommand;
import online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.memen.GraphCommandHistory;
import online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.memen.GraphCommandMemento;

import java.awt.*;

public class GraphEditor {

    private GraphCommandHistory history = new GraphCommandHistory();

    private online.javabook.pattern.gof.behavioral.patterns5.memento2.grapheditor.context.Shape shape = new Shape();

    public void color(Color newColor) {
        IGraphCommand command = new ColorCommand(newColor);
        command.execute(shape);

        GraphCommandMemento memento = new GraphCommandMemento(command);
        history.add(memento);

        System.out.println("->" + shape);
    }

    public void move(Point newPoint) {
        IGraphCommand command = new MoveCommand(newPoint);
        command.execute(shape);

        GraphCommandMemento memento = new GraphCommandMemento(command);
        history.add(memento);

        System.out.println("->" + shape);
    }

    public void undo() {
        GraphCommandMemento memento = history.getUndo();
        IGraphCommand command = memento.getState();
        command.execute(shape);

        System.out.println("<-" + shape);
    }

    public void redo() {
        GraphCommandMemento memento = history.getRedo();
        IGraphCommand command = memento.getState();
        command.execute(shape);

        System.out.println("->" + shape);
    }
}
