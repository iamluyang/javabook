package org.gof.structural.patterns1.adapter.objectadapter.socket;

import org.gof.structural.patterns1.adapter.objectadapter.plug.api.IChina2PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.plug.api.IUsa3PinPlug;

public class Usa3PinSocket {

    public void play(IUsa3PinPlug usa3PinPlug) {
        usa3PinPlug.runUsa3Pin();
    }

/*    public void play(IChina2PinPlug china2PinPlug) {
        china2PinPlug.runChina2Pin();
    }*/
}
