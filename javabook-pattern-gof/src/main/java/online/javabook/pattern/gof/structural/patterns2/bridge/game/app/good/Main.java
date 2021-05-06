package online.javabook.pattern.gof.structural.patterns2.bridge.game.app.good;

import online.javabook.pattern.gof.structural.patterns2.bridge.game.role.api.good.IRole;
import online.javabook.pattern.gof.structural.patterns2.bridge.game.role.impl.good.*;

public class Main {
    public static void main(String[] args) {
        IRole role1 = new Role1();
        role1.fire(new Gun());
        role1.fire(new Knife());
        role1.fire(new Magic());

        IRole role2 = new Role2();
        role2.fire(new Gun());
        role2.fire(new Knife());
        role2.fire(new Magic());

        IRole role3 = new Role3();
        role3.fire(new Gun());
        role3.fire(new Knife());
        role3.fire(new Magic());

        IRole role4 = new Role4();
        role4.fire(new Gun());
        role4.fire(new Knife());
        role4.fire(new Magic());
    }
}
