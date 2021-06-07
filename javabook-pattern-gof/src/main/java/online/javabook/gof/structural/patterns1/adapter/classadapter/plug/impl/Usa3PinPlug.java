package online.javabook.gof.structural.patterns1.adapter.classadapter.plug.impl;

import online.javabook.gof.structural.patterns1.adapter.classadapter.plug.api.IUsa3PinPlug;

public class Usa3PinPlug implements IUsa3PinPlug {

    @Override
    public void runUsa3Pin() {
        System.out.println("I am usa 3 pin plug, running");
    }
}
