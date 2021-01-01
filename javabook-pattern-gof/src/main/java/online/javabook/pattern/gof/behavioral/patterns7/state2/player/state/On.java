package online.javabook.pattern.gof.behavioral.patterns7.state2.player.state;

import online.javabook.pattern.gof.behavioral.patterns7.state2.player.context.IPod;

import java.util.concurrent.TimeUnit;

public class On implements IPodState {
    @Override
    public void change(IPod pod) {
        System.out.print("On ipod -> ");
        pod.setState(this);

        new Thread(() -> {
            while (true) {
                int musicIndex = pod.getMusicIndex();

                // play music
                System.out.println(pod.getMusics().get(musicIndex));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // check off/pause
                if(pod.getState() instanceof Off ||
                   pod.getState() instanceof Pause) {
                    return;
                }

                // check prev
                if(pod.getState() instanceof Prev) {
                    pod.setState(new Next());
                    continue;
                }

                pod.setState(new Next());
                pod.change();
            }
        }).start();
    }
}
