package online.javabook.design.gof.structural2.bridge.game.role.impl.bad;

import online.javabook.design.gof.structural2.bridge.game.role.api.bad.IRole;

public class Role2WithKnife implements IRole {

    @Override
    public void fire() {
        System.out.println("Role2 is cutting");
    }
}
