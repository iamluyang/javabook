package online.javabook.pattern.gof.structural.patterns1.adapter.defaultadapter.listener.impl;

import online.javabook.pattern.gof.structural.patterns1.adapter.defaultadapter.listener.api.Event;
import online.javabook.pattern.gof.structural.patterns1.adapter.defaultadapter.listener.api.IEventListener;

public class OnClickEventListener1 implements IEventListener {

    @Override
    public void onClick(Event e) {
        System.out.println("Button is clicked.");
    }

    @Override
    public void onDbClick(Event e) {

    }

    @Override
    public void onMouseDown(Event e) {

    }

    @Override
    public void onMouseOver(Event e) {

    }

    @Override
    public void onMouseUp(Event e) {

    }

    @Override
    public void onMouseOut(Event e) {

    }

    @Override
    public void onMouseMove(Event e) {

    }

}
