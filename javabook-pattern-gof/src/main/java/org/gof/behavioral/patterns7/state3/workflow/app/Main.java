package org.gof.behavioral.patterns7.state3.workflow.app;

import org.gof.behavioral.patterns7.state3.workflow.command.*;
import org.gof.behavioral.patterns7.state3.workflow.context.Activity;
import org.gof.behavioral.patterns7.state3.workflow.context.Flow;
import org.gof.behavioral.patterns7.state3.workflow.context.WorkflowEngine;
import org.gof.behavioral.patterns7.state3.workflow.flowstate.ActivityState;
import org.gof.behavioral.patterns7.state3.workflow.flowstate.FlowState;

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
