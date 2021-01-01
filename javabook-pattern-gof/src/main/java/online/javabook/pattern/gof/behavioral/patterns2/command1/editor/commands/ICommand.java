package online.javabook.pattern.gof.behavioral.patterns2.command1.editor.commands;

import online.javabook.pattern.gof.behavioral.patterns2.command1.editor.context.Editor;

public interface ICommand {

    void execute(Editor editor);
}
