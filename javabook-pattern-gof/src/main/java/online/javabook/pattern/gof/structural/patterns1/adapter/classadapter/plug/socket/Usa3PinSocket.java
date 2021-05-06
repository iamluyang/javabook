package online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.socket;

import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.api.IUsa3PinPlug;

public class Usa3PinSocket {

    public void play(IUsa3PinPlug usa3PinPlug) {
        usa3PinPlug.runUsa3Pin();
    }
}
