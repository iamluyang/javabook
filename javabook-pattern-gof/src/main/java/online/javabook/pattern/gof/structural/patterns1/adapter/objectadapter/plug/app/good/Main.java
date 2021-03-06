package online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.app.good;

import online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.adpter.China2PinPlugToUsa3PinPlugAdapter;
import online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.api.IChina2PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.api.IUsa3PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.impl.China2PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.impl.Usa3PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.objectadapter.plug.socket.Usa3PinSocket;

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
