package org.gof.behavioral.patterns7.state.player.state;

import org.gof.behavioral.patterns7.state.player.context.IPod;
import org.gof.behavioral.patterns7.state.trafficlight.state.YellowState;

import java.util.concurrent.TimeUnit;

public class On implements IPodState {
    @Override
    public void change(IPod pod) {
        try {
            while (true) {
                for (int musicIndex = pod.getMusicIndex(); musicIndex < pod.getMusics().size(); musicIndex++) {
                    System.out.println(pod.getMusics().get(musicIndex));
                    TimeUnit.SECONDS.sleep(10);
                }
                pod.setMusicIndex(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
