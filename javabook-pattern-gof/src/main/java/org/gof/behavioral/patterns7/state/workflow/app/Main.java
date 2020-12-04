package org.gof.behavioral.patterns7.state.workflow.app;

import org.gof.behavioral.patterns7.state.workflow.command.*;
import org.gof.behavioral.patterns7.state.workflow.context.Activity;
import org.gof.behavioral.patterns7.state.workflow.context.Flow;
import org.gof.behavioral.patterns7.state.workflow.context.WorkflowEngien;
import org.gof.behavioral.patterns7.state.workflow.flow.state.ActivityState;
import org.gof.behavioral.patterns7.state.workflow.flow.state.FlowState;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        WorkflowEngien workflowEngien = new WorkflowEngien();
        workflowEngien.getWorkflowStateTable().registerStateRow(
                FlowState.Initialize, ActivityState.Initialize, FlowStartCommand.class, FlowState.Running, ActivityState.Committing);

        workflowEngien.getWorkflowStateTable().registerStateRow(
                FlowState.Running, ActivityState.Committing, FlowCommitCommand.class, FlowState.Running, ActivityState.Committed);

        workflowEngien.getWorkflowStateTable().registerStateRow(
                FlowState.Running, ActivityState.Committing, FlowCancelCommand.class, FlowState.Canceled, ActivityState.Canceled);

        workflowEngien.getWorkflowStateTable().registerStateRow(
                FlowState.Running, ActivityState.Reviewing, FlowFinishCommand.class, FlowState.Finished, ActivityState.Approved);

        workflowEngien.getWorkflowStateTable().registerStateRow(
                FlowState.Running, ActivityState.Reviewing, FlowTernimateCommand.class, FlowState.Terminated, ActivityState.Approved);

        Flow flow = new Flow();
        Activity activity = new Activity();
        workflowEngien.CommitFlow(flow, activity);

        workflowEngien.FinishFlow(flow, activity);

        workflowEngien.TerminateFlow(flow, activity);
    }
}
