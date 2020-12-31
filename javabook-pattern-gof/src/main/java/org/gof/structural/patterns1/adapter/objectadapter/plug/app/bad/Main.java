package org.gof.structural.patterns1.adapter.objectadapter.plug.app.bad;

import org.gof.structural.patterns1.adapter.objectadapter.plug.api.IChina2PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.plug.api.IUsa3PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.plug.impl.China2PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.plug.impl.Usa3PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.plug.socket.Usa3PinSocket;

public class Main {
    public static void main(String[] args) {
        Usa3PinSocket usa3PinSocket = new Usa3PinSocket();

        IUsa3PinPlug usa3PinPlug = new Usa3PinPlug();
        usa3PinSocket.play(usa3PinPlug);

        IChina2PinPlug china2PinPlug = new China2PinPlug();
        //usa3PinSocket.play(china2PinPlug);
    }
}
