package org.gof.structural.patterns1.adapter.defaultadapter.listener.impl;

import org.gof.structural.patterns1.adapter.defaultadapter.listener.api.Event;
import org.gof.structural.patterns1.adapter.defaultadapter.listener.api.IEventListener;

public abstract class EventListenerDefaultAdapter implements IEventListener {

    @Override
    public void onClick(Event e) {
        // DefaultAdapter method
    }

    @Override
    public void onDbClick(Event e) {
        // DefaultAdapter method
    }

    @Override
    public void onMouseDown(Event e) {
        // DefaultAdapter method
    }

    @Override
    public void onMouseOver(Event e) {
        // DefaultAdapter method
    }

    @Override
    public void onMouseUp(Event e) {
        // DefaultAdapter method
    }

    @Override
    public void onMouseOut(Event e) {
        // DefaultAdapter method
    }

    @Override
    public void onMouseMove(Event e) {
        // DefaultAdapter method
    }
}
