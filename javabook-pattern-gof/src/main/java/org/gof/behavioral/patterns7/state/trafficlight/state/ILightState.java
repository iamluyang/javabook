package org.gof.behavioral.patterns7.state.trafficlight.state;

import org.gof.behavioral.patterns7.state.trafficlight.context.TrafficLight;

public interface ILightState {
    void change(TrafficLight light);
}
