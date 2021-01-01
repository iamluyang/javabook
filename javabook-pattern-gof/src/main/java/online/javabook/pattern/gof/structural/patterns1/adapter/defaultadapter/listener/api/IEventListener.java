package online.javabook.pattern.gof.structural.patterns1.adapter.defaultadapter.listener.api;

public interface IEventListener {

    public void onClick(Event e);

    public void onDbClick(Event e);

    public void onMouseDown(Event e);

    public void onMouseOver(Event e);

    public void onMouseUp(Event e);

    public void onMouseOut(Event e);

    public void onMouseMove(Event e);
}
