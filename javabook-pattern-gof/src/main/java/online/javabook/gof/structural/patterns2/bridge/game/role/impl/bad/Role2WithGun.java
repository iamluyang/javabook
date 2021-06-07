package online.javabook.gof.structural.patterns2.bridge.game.role.impl.bad;

import online.javabook.gof.structural.patterns2.bridge.game.role.api.bad.IRole;

public class Role2WithGun implements IRole {

    @Override
    public void fire() {
        System.out.println("Role2 is shooting");
    }
}
