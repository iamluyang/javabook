package online.javabook.gof.behavioral.patterns7.state3.workflow.command;

import online.javabook.gof.behavioral.patterns7.state3.workflow.context.Activity;
import online.javabook.gof.behavioral.patterns7.state3.workflow.context.Flow;
import online.javabook.gof.behavioral.patterns7.state3.workflow.statetable.FlowStateTransition;

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
