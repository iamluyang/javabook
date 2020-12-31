package org.gof.structural.patterns2.bridge.game.role.impl.good;

import org.gof.structural.patterns2.bridge.game.role.api.good.IArms;
import org.gof.structural.patterns2.bridge.game.role.api.good.IRole;

public class Role3 implements IRole {

    @Override
    public void fire(IArms arms) {
        arms.fire();
    }
}
