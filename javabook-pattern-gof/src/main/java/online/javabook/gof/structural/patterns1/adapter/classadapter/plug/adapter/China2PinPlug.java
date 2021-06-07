package online.javabook.gof.structural.patterns1.adapter.classadapter.plug.adapter;

import online.javabook.gof.structural.patterns1.adapter.classadapter.plug.api.IChina2PinPlug;
import online.javabook.gof.structural.patterns1.adapter.classadapter.plug.api.IUsa3PinPlug;

public class China2PinPlug implements IChina2PinPlug, IUsa3PinPlug {

    @Override
    public void runChina2Pin() {
        System.out.println("I am china 2 pin plug, running");
    }

    // adapter api
    @Override
    public void runUsa3Pin() {
        runChina2Pin();
    }
}
