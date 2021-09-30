package online.javabook.design.gof.structural1.adapter.classadapter.plug.adapter;

import online.javabook.design.gof.structural1.adapter.classadapter.plug.api.IUsa3PinPlug;
import online.javabook.design.gof.structural1.adapter.classadapter.plug.impl.China2PinPlug;

public class China2PinPlugToUsa3PinPlugAdapter extends China2PinPlug implements IUsa3PinPlug {

    @Override
    public void runUsa3Pin() {
        this.runChina2Pin();
    }
}
