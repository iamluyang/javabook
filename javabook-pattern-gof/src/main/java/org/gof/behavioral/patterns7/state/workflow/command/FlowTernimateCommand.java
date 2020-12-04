package org.gof.behavioral.patterns7.state.workflow.command;

import org.gof.behavioral.patterns7.state.workflow.context.Activity;
import org.gof.behavioral.patterns7.state.workflow.context.Flow;

public class FlowTernimateCommand implements ICommand {
    @Override
    public void doAction(Flow flow, Activity activity) {
        System.out.println("Commit");
    }
}
