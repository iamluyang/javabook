package org.gof.behavioral.patterns7.state2.player.state;

import org.gof.behavioral.patterns7.state2.player.context.IPod;

public class Prev implements IPodState {
    @Override
    public void change(IPod pod) {
        if(!(pod.getState() instanceof Off)) {
            System.out.print("On Prev -> ");
            pod.setState(this);

            int musicIndex = pod.getMusicIndex();
            pod.setMusicIndex(--musicIndex);
        }
    }
}
