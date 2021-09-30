package online.javabook.design.gof.structural1.adapter.defaultadapter.listener.app.good;

import online.javabook.design.gof.structural1.adapter.defaultadapter.listener.api.IEventListener;
import online.javabook.design.gof.structural1.adapter.defaultadapter.listener.impl.OnClickEventListener2;

public class Main {
    public static void main(String[] args) {
        IEventListener eventListener = new OnClickEventListener2();
    }
}
