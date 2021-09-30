package online.javabook.design.gof.behavioral2.command1.editor.commands;

import online.javabook.design.gof.behavioral2.command1.editor.context.Editor;

public interface ICommand {

    void execute(Editor editor);
}
