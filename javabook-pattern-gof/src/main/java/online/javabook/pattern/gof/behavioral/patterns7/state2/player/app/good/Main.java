package online.javabook.pattern.gof.behavioral.patterns7.state2.player.app.good;

import online.javabook.pattern.gof.behavioral.patterns7.state2.player.context.IPod;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        IPod iPod = new IPod();

        iPod.on(); // on

        Thread.sleep(12000);

        iPod.pause(); // on -> pause

        Thread.sleep(20000);

        iPod.pause(); // pause -> on

        Thread.sleep(27000);

        iPod.prev(); // prep

        Thread.sleep(25000);

        iPod.off();
    }
}
