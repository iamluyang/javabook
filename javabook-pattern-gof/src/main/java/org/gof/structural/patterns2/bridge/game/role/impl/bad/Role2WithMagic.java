package org.gof.structural.patterns2.bridge.game.role.impl.bad;

import org.gof.structural.patterns2.bridge.game.role.api.bad.IRole;

public class Role2WithMagic implements IRole {

    @Override
    public void run() {
        System.out.println("Role2 run");
    }

    @Override
    public void jump() {
        System.out.println("Role2 jump");
    }

    @Override
    public void fire() {
        System.out.println("Role2 is making magic");
    }
}
