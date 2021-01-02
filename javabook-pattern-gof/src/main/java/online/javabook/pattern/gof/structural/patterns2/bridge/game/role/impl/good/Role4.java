package online.javabook.pattern.gof.structural.patterns2.bridge.game.role.impl.good;

import online.javabook.pattern.gof.structural.patterns2.bridge.game.role.api.good.IArms;
import online.javabook.pattern.gof.structural.patterns2.bridge.game.role.api.good.IRole;

public class Role4 implements IRole {

    @Override
    public void fire(IArms arms) {
        arms.fire();
    }
}
