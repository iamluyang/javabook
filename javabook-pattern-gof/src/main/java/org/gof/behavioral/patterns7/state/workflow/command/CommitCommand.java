package org.gof.behavioral.patterns7.state.workflow.command;

import org.gof.behavioral.patterns7.state.workflow.context.Activity;
import org.gof.behavioral.patterns7.state.workflow.context.Flow;
import org.gof.behavioral.patterns7.state.workflow.statetable.FlowStateTransition;

public class CommitCommand implements ICommand {
    @Override
    public void doAction(Flow flow, Activity activity, FlowStateTransition workflowStateRow) {
        try {
            System.out.println("Committed");

            flow.setState(workflowStateRow.getTargetFlowState());
            activity.setState(workflowStateRow.getTargetActivityState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
