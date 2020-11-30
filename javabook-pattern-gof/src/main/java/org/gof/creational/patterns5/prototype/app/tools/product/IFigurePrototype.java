package org.gof.creational.patterns5.prototype.app.tools.product;

import java.io.IOException;

public interface IFigurePrototype {

    public IFigurePrototype shallowClone() throws CloneNotSupportedException;

    public IFigurePrototype deepClone() throws IOException, ClassNotFoundException, CloneNotSupportedException;
}
