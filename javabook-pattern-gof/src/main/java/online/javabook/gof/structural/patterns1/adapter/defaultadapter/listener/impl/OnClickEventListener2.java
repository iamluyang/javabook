package online.javabook.gof.structural.patterns1.adapter.defaultadapter.listener.impl;

import java.awt.*;

public class OnClickEventListener2 extends EventListenerDefaultAdapter {

    @Override
    public void onClick(Event e) {
        System.out.println("Button is clicked.");
    }

    @Override
    public void onDbClick(Event e) {
        System.out.println("Button is dbclicked.");
    }
}
