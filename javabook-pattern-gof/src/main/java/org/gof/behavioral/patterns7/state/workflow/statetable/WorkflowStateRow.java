package org.gof.behavioral.patterns7.state.workflow.statetable;

import org.gof.behavioral.patterns7.state.workflow.command.ICommand;
import org.gof.behavioral.patterns7.state.workflow.flow.state.ActivityState;
import org.gof.behavioral.patterns7.state.workflow.flow.state.FlowState;

public class WorkflowStateRow {

    private FlowState currentFlowState;

    private ActivityState currentActivityState;

    private Class<? extends ICommand> command;

    private FlowState targetFlowState;

    private ActivityState targetActivityState;

    public FlowState getCurrentFlowState() {
        return currentFlowState;
    }

    public void setCurrentFlowState(FlowState currentFlowState) {
        this.currentFlowState = currentFlowState;
    }

    public ActivityState getCurrentActivityState() {
        return currentActivityState;
    }

    public void setCurrentActivityState(ActivityState currentActivityState) {
        this.currentActivityState = currentActivityState;
    }

    public Class<? extends ICommand> getCommand() {
        return command;
    }

    public void setCommand(Class<? extends ICommand> command) {
        this.command = command;
    }

    public FlowState getTargetFlowState() {
        return targetFlowState;
    }

    public void setTargetFlowState(FlowState targetFlowState) {
        this.targetFlowState = targetFlowState;
    }

    public ActivityState getTargetActivityState() {
        return targetActivityState;
    }

    public void setTargetActivityState(ActivityState targetActivityState) {
        this.targetActivityState = targetActivityState;
    }
}
