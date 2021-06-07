package online.javabook.gof.structural.patterns1.adapter.classadapter.plug.impl;

import online.javabook.gof.structural.patterns1.adapter.classadapter.plug.api.IChina2PinPlug;

public class China2PinPlug implements IChina2PinPlug {

    @Override
    public void runChina2Pin() {
        System.out.println("I am china 2 pin plug, running");
    }
}
