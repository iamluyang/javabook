package org.gof.behavioral.patterns7.state.player.state;

import org.gof.behavioral.patterns7.state.player.context.IPod;

import java.util.concurrent.TimeUnit;

public class Off implements IPodState {
    @Override
    public void change(IPod pod) {
        try {
            for (String music : pod.getMusics()) {
                System.out.println(music);
                TimeUnit.SECONDS.sleep(10);
            }

            pod.setState(new Pause());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
