package org.gof.structural.patterns1.adapter.classadapter.plug.impl;

import org.gof.structural.patterns1.adapter.classadapter.plug.api.IChina2PinPlug;

public class China2PinPlug implements IChina2PinPlug {

    @Override
    public void runChina2Pin() {
        System.out.println("I am china 2 pin plug, running");
    }
}
