package online.javabook.gof.structural.patterns2.bridge.game.role.impl.bad;

import online.javabook.gof.structural.patterns2.bridge.game.role.api.bad.IRole;

public class Role3WithKnife implements IRole {

    @Override
    public void fire() {
        System.out.println("Role3 is cutting");
    }
}
