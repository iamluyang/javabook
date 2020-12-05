package org.gof.behavioral.patterns7.state3.workflow.command;

import org.gof.behavioral.patterns7.state3.workflow.context.Activity;
import org.gof.behavioral.patterns7.state3.workflow.context.Flow;
import org.gof.behavioral.patterns7.state3.workflow.statetable.FlowStateTransition;

public interface ICommand {
    void doAction(Flow flow, Activity activity, FlowStateTransition workflowStateRow);
}
