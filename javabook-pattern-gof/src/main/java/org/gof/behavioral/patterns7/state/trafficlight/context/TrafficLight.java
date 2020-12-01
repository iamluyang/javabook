package org.gof.behavioral.patterns7.state.trafficlight.context;

import org.gof.behavioral.patterns7.state.trafficlight.state.ILightState;
import org.gof.behavioral.patterns7.state.trafficlight.state.RedState;

public class TrafficLight {

    private ILightState state;

    public void setState(ILightState state) {
        this.state = state;
    }

    public void change() {
        state.change(this);
    }
}
