package org.gof.behavioral.patterns7.state3.workflow.command;

import org.gof.behavioral.patterns7.state3.workflow.context.Activity;
import org.gof.behavioral.patterns7.state3.workflow.context.Flow;
import org.gof.behavioral.patterns7.state3.workflow.statetable.FlowStateTransition;

public class FinishCommand implements ICommand {
    @Override
    public void doAction(Flow flow, Activity activity, FlowStateTransition workflowStateRow) {
        try {
            System.out.println("Finished");

            flow.setState(workflowStateRow.getTargetFlowState());
            activity.setState(workflowStateRow.getTargetActivityState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
