package online.javabook.pattern.gof.behavioral.patterns2.command1.editor.commands;

import online.javabook.pattern.gof.behavioral.patterns2.command1.editor.context.Editor;

@CommandAnnotation(name="copy")
public class CopyCommand implements ICommand {
    @Override
    public void execute(Editor editor) {
        System.out.println("click copy button");
    }
}
