package online.javabook.pattern.gof.behavioral.patterns7.state1.trafficlight.app.good;

import online.javabook.pattern.gof.behavioral.patterns7.state1.trafficlight.context.TrafficLight;
import online.javabook.pattern.gof.behavioral.patterns7.state1.trafficlight.state.RedState;

public class Main {
    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setState(new RedState());

        while (true) {
            trafficLight.change();
        }
    }
}
