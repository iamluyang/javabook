package org.gof.behavioral.patterns7.state3.workflow.statetable;

import org.gof.behavioral.patterns7.state3.workflow.command.ICommand;
import org.gof.behavioral.patterns7.state3.workflow.flowstate.ActivityState;
import org.gof.behavioral.patterns7.state3.workflow.flowstate.FlowState;

import java.util.ArrayList;
import java.util.List;

public class FlowStateTransitionTable {

    private List<FlowStateTransition> flowStateTransitions = new ArrayList<>();

    public void registerStateTransition(FlowState currentFlowState, ActivityState currentActivityState,
                                        Class<? extends ICommand> commandClass,
                                        FlowState targetFlowState, ActivityState targetActivityState) {

        FlowStateTransition flowStateTransition = new FlowStateTransition();
        flowStateTransition.setCurrentFlowState(currentFlowState);
        flowStateTransition.setCurrentActivityState(currentActivityState);
        flowStateTransition.setCommand(commandClass);
        flowStateTransition.setTargetActivityState(targetActivityState);
        flowStateTransition.setTargetFlowState(targetFlowState);

        flowStateTransitions.add(flowStateTransition);
    }

    public FlowStateTransition getFlowStateTransition(FlowState currentFlowState, ActivityState currentActivityState, Class<? extends ICommand> commandClass) throws Exception {

        for(FlowStateTransition flowStateTransition : flowStateTransitions){
            if(flowStateTransition.getCurrentFlowState().equals(currentFlowState) &&
                    flowStateTransition.getCurrentActivityState().equals(currentActivityState) &&
                    flowStateTransition.getCommand().equals(commandClass)) {

                return flowStateTransition;
            }
        }
        throw new Exception("No FlowStateTransition");
    }
}
