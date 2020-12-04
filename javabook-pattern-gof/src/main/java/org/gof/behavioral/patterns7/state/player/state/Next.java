package org.gof.behavioral.patterns7.state.player.state;

import org.gof.behavioral.patterns7.state.player.context.IPod;

public class Next implements IPodState {
    @Override
    public void change(IPod pod) {
        if(!(pod.getState() instanceof Off)) {
            System.out.print("On Next -> ");
            pod.setState(this);

            int musicIndex = pod.getMusicIndex();
            pod.setMusicIndex(++musicIndex);
        }
    }
}
