package org.gof.behavioral.patterns2.command1.editor.context;

import org.gof.behavioral.patterns2.command1.editor.commands.CommandAnnotation;
import org.gof.behavioral.patterns2.command1.editor.commands.ICommand;

import java.util.HashMap;
import java.util.Map;

public class Editor {

    private Map<String, ICommand> commandRegister = new HashMap<>();

    public void registerCommand(Class<? extends ICommand> commandClass) throws IllegalAccessException, InstantiationException {
        CommandAnnotation commandAnnotation = commandClass.getAnnotation(CommandAnnotation.class);
        ICommand command = commandClass.newInstance();
        commandRegister.put(commandAnnotation.name(), command);
    }

    public ICommand discoverCommand(String commandName) {
        return commandRegister.get(commandName);
    }

    public void doCommand(String commandName) {
        discoverCommand(commandName).execute(this);
    }
}
