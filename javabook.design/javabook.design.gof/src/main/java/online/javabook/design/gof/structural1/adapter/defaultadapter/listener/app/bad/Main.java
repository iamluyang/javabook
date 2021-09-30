package online.javabook.design.gof.structural1.adapter.defaultadapter.listener.app.bad;

import online.javabook.design.gof.structural1.adapter.defaultadapter.listener.impl.OnClickEventListener1;
import online.javabook.design.gof.structural1.adapter.defaultadapter.listener.api.IEventListener;

public class Main {
    public static void main(String[] args) {

        IEventListener eventListener = new OnClickEventListener1();
    }
}
