package org.gof.structural.patterns1.adapter.classadapter.plug.app.bad;

import org.gof.structural.patterns1.adapter.classadapter.plug.impl.China2PinPlug;

// not support multiple inheritance
public class China2PinPlugToUsa3PinPlugAdapter extends China2PinPlug/*, Usa3PinPlug*/ {

    /*@Override
    public void runUsa3Pin() {
        this.runChina2Pin();
    }*/
}
