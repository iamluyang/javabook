package online.javabook.gof.structural.patterns1.adapter.defaultadapter.listener.app.bad;

import online.javabook.gof.structural.patterns1.adapter.defaultadapter.listener.api.IEventListener;
import online.javabook.gof.structural.patterns1.adapter.defaultadapter.listener.impl.OnClickEventListener1;

public class Main {
    public static void main(String[] args) {

        IEventListener eventListener = new OnClickEventListener1();
    }
}
