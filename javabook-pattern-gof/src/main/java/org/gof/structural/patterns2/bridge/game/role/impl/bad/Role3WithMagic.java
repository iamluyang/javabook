package org.gof.structural.patterns2.bridge.game.role.impl.bad;

import org.gof.structural.patterns2.bridge.game.role.api.bad.IRole;

public class Role3WithMagic implements IRole {

    @Override
    public void run() {
        System.out.println("Role3 run");
    }

    @Override
    public void jump() {
        System.out.println("Role3 jump");
    }

    @Override
    public void fire() {
        System.out.println("Role3 is making magic");
    }
}
