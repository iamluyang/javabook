package online.javabook.pattern.gof.structural.patterns2.bridge.game.role.impl.bad;

import online.javabook.pattern.gof.structural.patterns2.bridge.game.role.api.bad.IRole;

public class Role3WithKnife implements IRole {

    @Override
    public void fire() {
        System.out.println("Role3 is cutting");
    }
}
