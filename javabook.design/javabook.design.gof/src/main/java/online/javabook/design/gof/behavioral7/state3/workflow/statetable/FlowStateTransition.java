package online.javabook.design.gof.behavioral7.state3.workflow.statetable;

import online.javabook.design.gof.behavioral7.state3.workflow.command.ICommand;
import online.javabook.design.gof.behavioral7.state3.workflow.flowstate.ActivityState;
import online.javabook.design.gof.behavioral7.state3.workflow.flowstate.FlowState;

public class FlowStateTransition {

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
