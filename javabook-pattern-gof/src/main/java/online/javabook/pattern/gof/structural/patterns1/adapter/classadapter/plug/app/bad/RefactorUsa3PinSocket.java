package online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.app.bad;

import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.api.IChina2PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.api.IUsa3PinPlug;

public class RefactorUsa3PinSocket {

    public void play(IUsa3PinPlug usa2PinPlug) {
        usa2PinPlug.runUsa3Pin();
    }

    // add new api
    public void play(IChina2PinPlug china2PinPlug) {
        china2PinPlug.runChina2Pin();
    }
}
