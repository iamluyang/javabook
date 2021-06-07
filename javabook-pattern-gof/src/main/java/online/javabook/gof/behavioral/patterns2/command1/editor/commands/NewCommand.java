package online.javabook.gof.behavioral.patterns2.command1.editor.commands;

import online.javabook.gof.behavioral.patterns2.command1.editor.context.Editor;

@CommandAnnotation(name="new")
public class NewCommand implements ICommand {
    @Override
    public void execute(Editor editor) {
        System.out.println("click new button");
    }
}
