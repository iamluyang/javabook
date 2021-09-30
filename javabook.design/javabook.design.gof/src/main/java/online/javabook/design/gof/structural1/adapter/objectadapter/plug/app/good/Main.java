package online.javabook.design.gof.structural1.adapter.objectadapter.plug.app.good;

import online.javabook.design.gof.structural1.adapter.objectadapter.plug.adpter.China2PinPlugToUsa3PinPlugAdapter;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.socket.Usa3PinSocket;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.api.IChina2PinPlug;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.api.IUsa3PinPlug;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.impl.China2PinPlug;
import online.javabook.design.gof.structural1.adapter.objectadapter.plug.impl.Usa3PinPlug;

public class Main {
    public static void main(String[] args) {
        Usa3PinSocket usa3PinSocket = new Usa3PinSocket();

        IUsa3PinPlug usa3PinPlug = new Usa3PinPlug();
        usa3PinSocket.play(usa3PinPlug);

        IChina2PinPlug china2PinPlug = new China2PinPlug();
        // 通过对象适配器兼容已有的api
        IUsa3PinPlug adapter = new China2PinPlugToUsa3PinPlugAdapter(china2PinPlug);
        usa3PinSocket.play(adapter);
    }
}
