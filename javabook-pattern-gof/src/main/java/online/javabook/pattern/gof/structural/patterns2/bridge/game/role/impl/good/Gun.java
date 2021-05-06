package online.javabook.pattern.gof.structural.patterns2.bridge.game.role.impl.good;

import online.javabook.pattern.gof.structural.patterns2.bridge.game.role.api.good.IArms;

public class Gun implements IArms {

    @Override
    public void fire() {
        System.out.println("shooting");
    }
}
