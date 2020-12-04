package org.gof.behavioral.patterns7.state.workflow.app;

import org.gof.behavioral.patterns7.state.workflow.command.*;
import org.gof.behavioral.patterns7.state.workflow.context.Activity;
import org.gof.behavioral.patterns7.state.workflow.context.Flow;
import org.gof.behavioral.patterns7.state.workflow.context.WorkflowEngine;
import org.gof.behavioral.patterns7.state.workflow.flow.state.ActivityState;
import org.gof.behavioral.patterns7.state.workflow.flow.state.FlowState;

public class Main {
    public static void main(String[] args) throws Exception {
        WorkflowEngine workflowEngien = new WorkflowEngine();

        workflowEngien.registerStateMachine(FlowState.Initialize, ActivityState.Initialize, StartCommand.class, FlowState.Running, ActivityState.Committing);
        workflowEngien.registerStateMachine(FlowState.Running, ActivityState.Committing, CommitCommand.class, FlowState.Running, ActivityState.Committed);
        workflowEngien.registerStateMachine(FlowState.Running, ActivityState.Committing, CancelCommand.class, FlowState.Canceled, ActivityState.Canceled);
        workflowEngien.registerStateMachine(FlowState.Running, ActivityState.Reviewing, FinishCommand.class, FlowState.Finished, ActivityState.Approved);
        workflowEngien.registerStateMachine(FlowState.Running, ActivityState.Reviewing, TerminateCommand.class, FlowState.Terminated, ActivityState.Approved);
        workflowEngien.registerStateMachine(FlowState.Canceled, ActivityState.Reviewing, TerminateCommand.class, FlowState.Terminated, ActivityState.Approved);

        Flow flow = new Flow();
        flow.setState(FlowState.Initialize);

        Activity activity = new Activity();
        activity.setState(ActivityState.Initialize);

        workflowEngien.StartFlow(flow, activity);

        workflowEngien.CommitFlow(flow, activity);

    }
}
