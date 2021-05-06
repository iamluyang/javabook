package online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.app.bad;

import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.api.IChina2PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.api.IUsa3PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.impl.China2PinPlug;
import online.javabook.pattern.gof.structural.patterns1.adapter.classadapter.plug.impl.Usa3PinPlug;

public class Main {
    public static void main(String[] args) {
        RefactorUsa3PinSocket refactorUsa3PinSocket = new RefactorUsa3PinSocket();

        IUsa3PinPlug usa3PinPlug = new Usa3PinPlug();
        refactorUsa3PinSocket.play(usa3PinPlug);

        // run on new api
        IChina2PinPlug china2PinPlug = new China2PinPlug();
        refactorUsa3PinSocket.play(china2PinPlug);
    }
}
