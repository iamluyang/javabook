package online.javabook.design.gof.behavioral2.command1.editor.app;

import online.javabook.design.gof.behavioral2.command1.editor.commands.*;
import online.javabook.design.gof.behavioral2.command1.editor.context.Editor;
import online.javabook.design.gof.behavioral2.command1.editor.commands.*;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Editor editor = new Editor();
        editor.registerCommand(NewCommand.class);
        editor.registerCommand(OpenCommand.class);
        editor.registerCommand(CopyCommand.class);
        editor.registerCommand(CutCommand.class);
        editor.registerCommand(PasteCommand.class);

        editor.doCommand("new");
        editor.doCommand("open");
        editor.doCommand("copy");
        editor.doCommand("cut");
        editor.doCommand("paste");
    }
}
