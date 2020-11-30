package org.gof.structural.patterns2.bridge.game.role.api.good;

public interface IRole {

    public void Run();

    public void Jump();

    public void fire(IArms arms);
}
