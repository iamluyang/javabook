package org.gof.behavioral.patterns7.state.workflow.context;

import org.gof.behavioral.patterns7.state.workflow.flow.state.FlowState;

public class Flow {

    private FlowState state;

    public FlowState getState() {
        return state;
    }

    public void setState(FlowState state) {
        this.state = state;
    }
}
