package online.javabook.design.gof.structural2.bridge.game.role.impl.bad;

import online.javabook.design.gof.structural2.bridge.game.role.api.bad.IRole;

public class Role4WithGun implements IRole {

    @Override
    public void fire() {
        System.out.println("Role4 is shooting");
    }
}
