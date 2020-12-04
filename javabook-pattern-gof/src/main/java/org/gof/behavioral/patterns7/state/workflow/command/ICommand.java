package org.gof.behavioral.patterns7.state.workflow.command;

import org.gof.behavioral.patterns7.state.workflow.context.Activity;
import org.gof.behavioral.patterns7.state.workflow.context.Flow;

public interface ICommand {
    void doAction(Flow flow, Activity activity);
}
