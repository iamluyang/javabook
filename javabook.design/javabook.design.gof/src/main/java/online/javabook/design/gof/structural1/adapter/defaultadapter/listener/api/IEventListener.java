package online.javabook.design.gof.structural1.adapter.defaultadapter.listener.api;

import java.awt.*;

public interface IEventListener {

    public void onClick(Event e);

    public void onDbClick(Event e);

    public void onMouseDown(Event e);

    public void onMouseOver(Event e);

    public void onMouseUp(Event e);

    public void onMouseOut(Event e);

    public void onMouseMove(Event e);
}
