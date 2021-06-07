package online.javabook.gof.structural.patterns1.adapter.objectadapter.plug.adpter;

import online.javabook.gof.structural.patterns1.adapter.objectadapter.plug.api.IChina2PinPlug;
import online.javabook.gof.structural.patterns1.adapter.objectadapter.plug.api.IUsa3PinPlug;

public class China2PinPlugToUsa3PinPlugAdapter implements IUsa3PinPlug {

    private IChina2PinPlug china2PinPlug;

    public China2PinPlugToUsa3PinPlugAdapter(IChina2PinPlug china2PinPlug) {
        this.china2PinPlug = china2PinPlug;
    }

    @Override
    public void runUsa3Pin() {
        china2PinPlug.runChina2Pin();
    }
}
