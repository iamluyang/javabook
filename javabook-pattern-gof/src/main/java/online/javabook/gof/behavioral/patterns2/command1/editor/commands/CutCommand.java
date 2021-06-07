package online.javabook.gof.behavioral.patterns2.command1.editor.commands;

import online.javabook.gof.behavioral.patterns2.command1.editor.context.Editor;

@CommandAnnotation(name="cut")
public class CutCommand implements ICommand {
    @Override
    public void execute(Editor editor) {
        System.out.println("click cut button");
    }
}
