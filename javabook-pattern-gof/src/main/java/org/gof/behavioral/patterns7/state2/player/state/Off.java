package org.gof.behavioral.patterns7.state2.player.state;

import org.gof.behavioral.patterns7.state2.player.context.IPod;

public class Off implements IPodState {
    @Override
    public void change(IPod pod) {
        System.out.println("Off ipod");
        pod.setState(this);
    }
}
