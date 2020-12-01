package org.gof.behavioral.patterns7.state.trafficlight.app.good;

import org.gof.behavioral.patterns7.state.trafficlight.context.TrafficLight;
import org.gof.behavioral.patterns7.state.trafficlight.state.RedState;

public class Main {
    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setState(new RedState());

        while (true) {
            trafficLight.change();
        }
    }
}
