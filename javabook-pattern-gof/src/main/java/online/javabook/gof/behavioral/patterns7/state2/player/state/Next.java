package online.javabook.gof.behavioral.patterns7.state2.player.state;

import online.javabook.gof.behavioral.patterns7.state2.player.context.IPod;

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
