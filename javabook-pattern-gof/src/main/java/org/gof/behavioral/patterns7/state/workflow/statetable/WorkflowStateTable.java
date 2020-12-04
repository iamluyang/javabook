package org.gof.behavioral.patterns7.state.workflow.statetable;

import org.gof.behavioral.patterns7.state.workflow.command.ICommand;
import org.gof.behavioral.patterns7.state.workflow.flow.state.ActivityState;
import org.gof.behavioral.patterns7.state.workflow.flow.state.FlowState;

import java.util.ArrayList;
import java.util.List;

public class WorkflowStateTable {

    private List<WorkflowStateRow> workflowStateRows = new ArrayList<>();

    public void registerStateRow(FlowState currentFlowState, ActivityState currentActivityState,
                                 Class<? extends ICommand> commandClass,
                                 FlowState targetFlowState, ActivityState targetActivityState) {

        WorkflowStateRow wfStateRow = new WorkflowStateRow();
        wfStateRow.setCurrentFlowState(currentFlowState);
        wfStateRow.setCurrentActivityState(currentActivityState);
        wfStateRow.setCommand(commandClass);
        wfStateRow.setTargetActivityState(targetActivityState);
        wfStateRow.setTargetFlowState(targetFlowState);

        workflowStateRows.add(wfStateRow);
    }

    public WorkflowStateRow getStateRow(FlowState currentFlowState, ActivityState currentActivityState, Class<? extends ICommand> commandClass) {

        for(WorkflowStateRow wfStateRow : workflowStateRows){
            if(wfStateRow.getCurrentFlowState().equals(currentFlowState) &&
            wfStateRow.getCurrentActivityState().equals(currentActivityState) &&
            wfStateRow.getCommand().equals(commandClass)) {
                return wfStateRow;
            }
        }
        return null;
    }
}
