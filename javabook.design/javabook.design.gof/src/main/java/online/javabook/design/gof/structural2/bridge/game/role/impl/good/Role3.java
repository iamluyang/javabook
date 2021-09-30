package online.javabook.design.gof.structural2.bridge.game.role.impl.good;

import online.javabook.design.gof.structural2.bridge.game.role.api.good.IRole;
import online.javabook.design.gof.structural2.bridge.game.role.api.good.IArms;

public class Role3 implements IRole {

    @Override
    public void fire(IArms arms) {
        arms.fire();
    }
}
