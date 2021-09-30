package online.javabook.design.gof.structural2.bridge.game.role.impl.bad;

import online.javabook.design.gof.structural2.bridge.game.role.api.bad.IRole;

public class Role1WithMagic implements IRole {

    @Override
    public void fire() {
        System.out.println("Role1 is making magic");
    }
}
