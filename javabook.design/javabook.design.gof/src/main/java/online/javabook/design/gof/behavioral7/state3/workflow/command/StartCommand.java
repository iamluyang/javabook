package online.javabook.design.gof.behavioral7.state3.workflow.command;

import online.javabook.design.gof.behavioral7.state3.workflow.context.Activity;
import online.javabook.design.gof.behavioral7.state3.workflow.context.Flow;
import online.javabook.design.gof.behavioral7.state3.workflow.statetable.FlowStateTransition;

public class StartCommand implements ICommand {
    @Override
    public void doAction(Flow flow, Activity activity, FlowStateTransition workflowStateRow) {
        try {
            System.out.println("Started");

            flow.setState(workflowStateRow.getTargetFlowState());
            activity.setState(workflowStateRow.getTargetActivityState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
