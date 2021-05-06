package online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.app.good;

import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.adapter.China2PinPlugToUsa3PinPlugAdapter;
import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.api.IUsa3PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.impl.Usa3PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.socket.Usa3PinSocket;

public class Main {
    public static void main(String[] args) {
        Usa3PinSocket usa3PinSocket = new Usa3PinSocket();

        IUsa3PinPlug usa3PinPlug = new Usa3PinPlug();
        usa3PinSocket.play(usa3PinPlug);

        IUsa3PinPlug adapter = new China2PinPlugToUsa3PinPlugAdapter();
        usa3PinSocket.play(adapter);
    }
}
