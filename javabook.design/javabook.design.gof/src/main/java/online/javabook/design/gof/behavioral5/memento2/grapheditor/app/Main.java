package online.javabook.design.gof.behavioral5.memento2.grapheditor.app;

import online.javabook.design.gof.behavioral5.memento2.grapheditor.context.GraphEditor;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GraphEditor graphEditor = new GraphEditor();
        graphEditor.color(Color.red);
        graphEditor.color(Color.orange);
        graphEditor.color(Color.yellow);

        graphEditor.move(new Point(1,1));
        graphEditor.move(new Point(2,2));
        graphEditor.move(new Point(3,3));

        graphEditor.undo();
        graphEditor.undo();

        graphEditor.redo();
        graphEditor.redo();
    }
}
