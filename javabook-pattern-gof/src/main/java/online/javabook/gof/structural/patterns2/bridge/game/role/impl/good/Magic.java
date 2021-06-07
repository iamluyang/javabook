package online.javabook.gof.structural.patterns2.bridge.game.role.impl.good;

import online.javabook.gof.structural.patterns2.bridge.game.role.api.good.IArms;

public class Magic implements IArms {

    @Override
    public void fire() {
        System.out.println("magic");
    }
}
