package online.javabook.design.gof.structural1.adapter.objectadapter.plug.app.bad;

import online.javabook.design.gof.structural1.adapter.objectadapter.plug.impl.China2PinPlug;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.impl.Usa3PinPlug;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.socket.Usa3PinSocket;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.api.IChina2PinPlug;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.api.IUsa3PinPlug;

public class Main {
    public static void main(String[] args) {
        Usa3PinSocket usa3PinSocket = new Usa3PinSocket();

        IUsa3PinPlug usa3PinPlug = new Usa3PinPlug();
        usa3PinSocket.play(usa3PinPlug);

        IChina2PinPlug china2PinPlug = new China2PinPlug();
        //usa3PinSocket.play(china2PinPlug);
    }
}
