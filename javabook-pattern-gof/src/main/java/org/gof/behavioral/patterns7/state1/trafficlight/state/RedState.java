package org.gof.behavioral.patterns7.state1.trafficlight.state;

import org.gof.behavioral.patterns7.state1.trafficlight.context.TrafficLight;

import java.util.concurrent.TimeUnit;

public class RedState implements ILightState {

    @Override
    public void change(TrafficLight trafficLight) {
        try {
            System.out.println("现在是红灯 请等待10秒");
            TimeUnit.SECONDS.sleep(10);

            trafficLight.setState(new GreenState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
