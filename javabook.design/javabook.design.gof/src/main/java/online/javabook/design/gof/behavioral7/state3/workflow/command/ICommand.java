package online.javabook.design.gof.behavioral7.state3.workflow.command;

import online.javabook.design.gof.behavioral7.state3.workflow.context.Activity;
import online.javabook.design.gof.behavioral7.state3.workflow.context.Flow;
import online.javabook.design.gof.behavioral7.state3.workflow.statetable.FlowStateTransition;

public interface ICommand {
    void doAction(Flow flow, Activity activity, FlowStateTransition workflowStateRow);
}
