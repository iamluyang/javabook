package org.gof.behavioral.patterns7.state1.trafficlight.state;

import org.gof.behavioral.patterns7.state1.trafficlight.context.TrafficLight;

import java.util.concurrent.TimeUnit;

public class YellowState implements ILightState {

    @Override
    public void change(TrafficLight trafficLight) {
        try {
            System.out.println("现在是黄灯 请等待3秒");
            TimeUnit.SECONDS.sleep(3);

            trafficLight.setState(new RedState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
