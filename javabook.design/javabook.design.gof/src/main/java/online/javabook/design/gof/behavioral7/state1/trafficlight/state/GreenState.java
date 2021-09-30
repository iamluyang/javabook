package online.javabook.design.gof.behavioral7.state1.trafficlight.state;

import online.javabook.design.gof.behavioral7.state1.trafficlight.context.TrafficLight;

import java.util.concurrent.TimeUnit;

public class GreenState implements ILightState {

    @Override
    public void change(TrafficLight trafficLight) {
        try {
            System.out.println("现在是绿灯 请等待5秒");
            TimeUnit.SECONDS.sleep(5);

            trafficLight.setState(new YellowState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
