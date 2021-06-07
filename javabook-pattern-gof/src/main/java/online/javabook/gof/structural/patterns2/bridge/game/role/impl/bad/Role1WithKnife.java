package online.javabook.gof.structural.patterns2.bridge.game.role.impl.bad;

import online.javabook.gof.structural.patterns2.bridge.game.role.api.bad.IRole;

public class Role1WithKnife implements IRole {

    @Override
    public void fire() {
        System.out.println("Role1 is cutting");
    }
}
