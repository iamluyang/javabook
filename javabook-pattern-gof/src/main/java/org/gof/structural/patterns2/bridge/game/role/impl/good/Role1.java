package org.gof.structural.patterns2.bridge.game.role.impl.good;

import org.gof.structural.patterns2.bridge.game.role.api.good.IArms;
import org.gof.structural.patterns2.bridge.game.role.api.good.IRole;

public class Role1 implements IRole {

    @Override
    public void Run() {
        System.out.println("Role1 run");
    }

    @Override
    public void Jump() {
        System.out.println("Role1 jump");
    }

    @Override
    public void fire(IArms arms) {
        arms.fire();
    }
}
