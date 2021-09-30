package online.javabook.design.gof.behavioral7.state3.workflow.context;

import online.javabook.design.gof.behavioral7.state3.workflow.flowstate.FlowState;

public class Flow {

    private FlowState state;

    public FlowState getState() {
        return state;
    }

    public void setState(FlowState state) {
        this.state = state;
    }
}
