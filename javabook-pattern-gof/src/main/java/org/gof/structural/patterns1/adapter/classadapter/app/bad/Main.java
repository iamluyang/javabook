package org.gof.structural.patterns1.adapter.classadapter.app.bad;

import org.gof.structural.patterns1.adapter.classadapter.plug.api.IChina2PinPlug;
import org.gof.structural.patterns1.adapter.classadapter.plug.api.IUsa3PinPlug;
import org.gof.structural.patterns1.adapter.classadapter.plug.impl.China2PinPlug;
import org.gof.structural.patterns1.adapter.classadapter.plug.impl.Usa3PinPlug;
import org.gof.structural.patterns1.adapter.classadapter.socket.Usa3PinSocket;

public class Main {
    public static void main(String[] args) {
        Usa3PinSocket usa3PinSocket1 = new Usa3PinSocket();
        RefactorUsa3PinSocket usa3PinSocket2 = new RefactorUsa3PinSocket();

        IUsa3PinPlug usa3PinPlug = new Usa3PinPlug();
        usa3PinSocket2.play(usa3PinPlug);

        // run on new api
        IChina2PinPlug china2PinPlug = new China2PinPlug();
        usa3PinSocket2.play(china2PinPlug);
    }
}
