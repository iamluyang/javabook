package org.gof.structural.patterns2.bridge.game.role.impl.bad;

import org.gof.structural.patterns2.bridge.game.role.api.bad.IRole;

public class Role1WithMagic implements IRole {

    @Override
    public void fire() {
        System.out.println("Role1 is making magic");
    }
}
