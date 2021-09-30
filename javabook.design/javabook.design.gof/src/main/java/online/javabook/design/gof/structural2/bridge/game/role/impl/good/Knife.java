package online.javabook.design.gof.structural2.bridge.game.role.impl.good;

import online.javabook.design.gof.structural2.bridge.game.role.api.good.IArms;

public class Knife implements IArms {

    @Override
    public void fire() {
        System.out.println("catting");
    }
}
