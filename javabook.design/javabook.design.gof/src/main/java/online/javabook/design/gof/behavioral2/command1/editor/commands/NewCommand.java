package online.javabook.design.gof.behavioral2.command1.editor.commands;

import online.javabook.design.gof.behavioral2.command1.editor.context.Editor;

@CommandAnnotation(name="new")
public class NewCommand implements ICommand {
    @Override
    public void execute(Editor editor) {
        System.out.println("click new button");
    }
}
