package online.javabook.gof.behavioral.patterns7.state1.trafficlight.state;

import online.javabook.gof.behavioral.patterns7.state1.trafficlight.context.TrafficLight;

public interface ILightState {
    void change(TrafficLight light);
}
