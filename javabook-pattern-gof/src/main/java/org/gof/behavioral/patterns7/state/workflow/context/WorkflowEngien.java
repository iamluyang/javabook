package org.gof.behavioral.patterns7.state.workflow.context;

import org.gof.behavioral.patterns7.state.workflow.command.*;
import org.gof.behavioral.patterns7.state.workflow.statetable.WorkflowStateRow;
import org.gof.behavioral.patterns7.state.workflow.statetable.WorkflowStateTable;

public class WorkflowEngien {

    private WorkflowStateTable workflowStateTable = new WorkflowStateTable();

    public WorkflowStateTable getWorkflowStateTable() {
        return workflowStateTable;
    }

    public void StartFlow(Flow flow, Activity currentActivity) throws IllegalAccessException, InstantiationException {
        WorkflowStateRow wfStateRow = workflowStateTable.getStateRow(flow.getState(), currentActivity.getState() , FlowStartCommand.class);
        ICommand command = wfStateRow.getCommand().newInstance();
        command.doAction(flow, currentActivity);
    }

    public void CommitFlow(Flow flow, Activity currentActivity) throws IllegalAccessException, InstantiationException {
        WorkflowStateRow wfStateRow = workflowStateTable.getStateRow(flow.getState(), currentActivity.getState() , FlowCommitCommand.class);
        ICommand command = wfStateRow.getCommand().newInstance();
        command.doAction(flow, currentActivity);
    }

    public void FinishFlow(Flow flow, Activity currentActivity) throws IllegalAccessException, InstantiationException {
        WorkflowStateRow wfStateRow = workflowStateTable.getStateRow(flow.getState(), currentActivity.getState() , FlowFinishCommand.class);
        ICommand command = wfStateRow.getCommand().newInstance();
        command.doAction(flow, currentActivity);
    }

    public void TerminateFlow(Flow flow, Activity currentActivity) throws IllegalAccessException, InstantiationException {
        WorkflowStateRow wfStateRow = workflowStateTable.getStateRow(flow.getState(), currentActivity.getState() , FlowTernimateCommand.class);
        ICommand command = wfStateRow.getCommand().newInstance();
        command.doAction(flow, currentActivity);
    }
}
