package online.javabook.pattern.gof.behavioral.patterns7.state2.player.state;

import online.javabook.pattern.gof.behavioral.patterns7.state2.player.context.IPod;

public class Pause implements IPodState {
    @Override
    public void change(IPod pod) {
        if(pod.getState() instanceof Pause) {
            pod.setState(new On());
            pod.change();

        } else if(!(pod.getState() instanceof Off)) {
            System.out.println("Pause ipod");
            pod.setState(this);
        }
    }
}
