package online.javabook.gof.behavioral.patterns2.command1.editor.commands;

import online.javabook.gof.behavioral.patterns2.command1.editor.context.Editor;

public interface ICommand {

    void execute(Editor editor);
}
