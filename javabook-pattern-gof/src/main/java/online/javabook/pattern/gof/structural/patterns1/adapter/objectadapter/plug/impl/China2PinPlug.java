package online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.impl;

import online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.api.IChina2PinPlug;

public class China2PinPlug implements IChina2PinPlug {

    @Override
    public void runChina2Pin() {
        System.out.println("I am china 2 pin plug, running");
    }
}
