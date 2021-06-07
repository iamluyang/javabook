package online.javabook.gof.structural.patterns2.bridge.game.app.bad;

import online.javabook.gof.structural.patterns2.bridge.game.role.api.bad.IRole;
import online.javabook.gof.structural.patterns2.bridge.game.role.impl.bad.Role1WithGun;
import online.javabook.gof.structural.patterns2.bridge.game.role.impl.bad.Role1WithKnife;
import online.javabook.gof.structural.patterns2.bridge.game.role.impl.bad.Role2WithMagic;

public class Main {

    public static void main(String[] args) {
        IRole role1WithGun = new Role1WithGun();
        role1WithGun.fire();

        IRole role1WithKnife = new Role1WithKnife();
        role1WithKnife.fire();

        IRole role2WithMagic = new Role2WithMagic();
        role2WithMagic.fire();
    }
}
