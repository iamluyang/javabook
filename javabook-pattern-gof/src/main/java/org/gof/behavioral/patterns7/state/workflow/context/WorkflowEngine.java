package org.gof.behavioral.patterns7.state.workflow.context;

import org.gof.behavioral.patterns7.state.workflow.command.*;
import org.gof.behavioral.patterns7.state.workflow.flow.state.ActivityState;
import org.gof.behavioral.patterns7.state.workflow.flow.state.FlowState;
import org.gof.behavioral.patterns7.state.workflow.statetable.FlowStateTransition;
import org.gof.behavioral.patterns7.state.workflow.statetable.FlowStateTransitionTable;

public class WorkflowEngine {

    private FlowStateTransitionTable workflowStateTable = new FlowStateTransitionTable();

    public void registerStateMachine(
            FlowState currentFlowState, ActivityState currentActivityState,
            Class<? extends ICommand> commandClass,
            FlowState targetFlowState, ActivityState targetActivityState) {

        workflowStateTable.registerStateTransition(currentFlowState, currentActivityState, commandClass, targetFlowState, targetActivityState);
    }

    public void StartFlow(Flow flow, Activity currentActivity) throws Exception {
        FlowStateTransition flowStateTransition = workflowStateTable.getFlowStateTransition(flow.getState(), currentActivity.getState() , StartCommand.class);
        ICommand command = flowStateTransition.getCommand().newInstance();
        command.doAction(flow, currentActivity, flowStateTransition);
    }

    public void CommitFlow(Flow flow, Activity currentActivity) throws Exception {
        FlowStateTransition flowStateTransition = workflowStateTable.getFlowStateTransition(flow.getState(), currentActivity.getState() , CommitCommand.class);
        ICommand command = flowStateTransition.getCommand().newInstance();
        command.doAction(flow, currentActivity, flowStateTransition);
    }

    public void CancelFlow(Flow flow, Activity currentActivity) throws Exception {
        FlowStateTransition flowStateTransition = workflowStateTable.getFlowStateTransition(flow.getState(), currentActivity.getState() , CancelCommand.class);
        ICommand command = flowStateTransition.getCommand().newInstance();
        command.doAction(flow, currentActivity, flowStateTransition);
    }

    public void RejectFlow(Flow flow, Activity currentActivity) throws Exception {
        FlowStateTransition flowStateTransition = workflowStateTable.getFlowStateTransition(flow.getState(), currentActivity.getState() , RejectCommand.class);
        ICommand command = flowStateTransition.getCommand().newInstance();
        command.doAction(flow, currentActivity, flowStateTransition);
    }

    public void FinishFlow(Flow flow, Activity currentActivity) throws Exception {
        FlowStateTransition flowStateTransition = workflowStateTable.getFlowStateTransition(flow.getState(), currentActivity.getState() , FinishCommand.class);
        ICommand command = flowStateTransition.getCommand().newInstance();
        command.doAction(flow, currentActivity, flowStateTransition);
    }

    public void TerminateFlow(Flow flow, Activity currentActivity) throws Exception {
        FlowStateTransition flowStateTransition = workflowStateTable.getFlowStateTransition(flow.getState(), currentActivity.getState() , TerminateCommand.class);
        ICommand command = flowStateTransition.getCommand().newInstance();
        command.doAction(flow, currentActivity, flowStateTransition);
    }
}
