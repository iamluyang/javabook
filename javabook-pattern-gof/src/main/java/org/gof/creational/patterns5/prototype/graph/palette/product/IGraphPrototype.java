package org.gof.creational.patterns5.prototype.graph.palette.product;

import java.io.IOException;

public interface IGraphPrototype {

    public IGraphPrototype shallowClone() throws CloneNotSupportedException;

    public IGraphPrototype deepClone() throws IOException, ClassNotFoundException, CloneNotSupportedException;
}
