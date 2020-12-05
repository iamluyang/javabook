package org.gof.behavioral.patterns2.command1.editor.commands;

import org.gof.behavioral.patterns2.command1.editor.context.Editor;

@CommandAnnotation(name="open")
public class OpenCommand implements ICommand {
    @Override
    public void execute(Editor editor) {
        System.out.println("click open button");
    }
}
