package org.gof.behavioral.patterns7.state1.trafficlight.state;

import org.gof.behavioral.patterns7.state1.trafficlight.context.TrafficLight;

public interface ILightState {
    void change(TrafficLight light);
}
