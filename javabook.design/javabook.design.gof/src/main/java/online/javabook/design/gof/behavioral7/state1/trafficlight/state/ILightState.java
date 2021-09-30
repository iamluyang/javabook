package online.javabook.design.gof.behavioral7.state1.trafficlight.state;

import online.javabook.design.gof.behavioral7.state1.trafficlight.context.TrafficLight;

public interface ILightState {
    void change(TrafficLight light);
}
