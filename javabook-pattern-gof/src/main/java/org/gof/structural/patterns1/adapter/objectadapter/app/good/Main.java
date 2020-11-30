package org.gof.structural.patterns1.adapter.objectadapter.app.good;

import org.gof.structural.patterns1.adapter.objectadapter.plug.adpter.China2PinPlugToUsa3PinPlugAdapter;
import org.gof.structural.patterns1.adapter.objectadapter.plug.api.IChina2PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.plug.api.IUsa3PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.plug.impl.China2PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.plug.impl.Usa3PinPlug;
import org.gof.structural.patterns1.adapter.objectadapter.socket.Usa3PinSocket;

public class Main {
    public static void main(String[] args) {
        Usa3PinSocket usa3PinSocket = new Usa3PinSocket();

        IUsa3PinPlug usa3PinPlug = new Usa3PinPlug();
        usa3PinSocket.play(usa3PinPlug);

        IChina2PinPlug china2PinPlug = new China2PinPlug();
        IUsa3PinPlug adapter = new China2PinPlugToUsa3PinPlugAdapter(china2PinPlug);
        usa3PinSocket.play(adapter);
    }
}
