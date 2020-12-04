package org.gof.behavioral.patterns7.state.player.state;

import org.gof.behavioral.patterns7.state.player.context.IPod;

import java.util.concurrent.TimeUnit;

public class Off implements IPodState {
    @Override
    public void change(IPod pod) {
        System.out.println("Off ipod");
        pod.setState(this);
    }
}
