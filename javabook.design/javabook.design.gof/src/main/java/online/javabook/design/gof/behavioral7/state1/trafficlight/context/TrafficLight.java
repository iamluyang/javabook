package online.javabook.design.gof.behavioral7.state1.trafficlight.context;

import online.javabook.design.gof.behavioral7.state1.trafficlight.state.ILightState;

public class TrafficLight {

    private ILightState state;

    public void setState(ILightState state) {
        this.state = state;
    }

    public void change() {
        state.change(this);
    }
}
