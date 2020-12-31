package org.gof.structural.patterns2.bridge.game.role.impl.bad;

import org.gof.structural.patterns2.bridge.game.role.api.bad.IRole;

public class Role4WithMagic implements IRole {

    @Override
    public void fire() {
        System.out.println("Role4 is making magic");
    }
}
