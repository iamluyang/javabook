package online.javabook.design.gof.behavioral2.command1.editor.commands;

import online.javabook.design.gof.behavioral2.command1.editor.context.Editor;

@CommandAnnotation(name="copy")
public class CopyCommand implements ICommand {
    @Override
    public void execute(Editor editor) {
        System.out.println("click copy button");
    }
}
