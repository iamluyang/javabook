package online.javabook.pattern.gof.behavioral.patterns7.state1.trafficlight.state;

import online.javabook.pattern.gof.behavioral.patterns7.state1.trafficlight.context.TrafficLight;

import java.util.concurrent.TimeUnit;

public class GreenState implements ILightState {

    @Override
    public void change(TrafficLight trafficLight) {
        try {
            System.out.println("现在是绿灯 请等待10秒");
            TimeUnit.SECONDS.sleep(10);

            trafficLight.setState(new RedState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
