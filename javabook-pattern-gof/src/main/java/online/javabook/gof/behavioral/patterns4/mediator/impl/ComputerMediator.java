package online.javabook.gof.behavioral.patterns4.mediator.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;

import java.util.HashMap;
import java.util.Map;

public class ComputerMediator implements IMediator {

    private Map<Class, DeviceColleague> colleagues = new HashMap<>();

    @Override
    public void registerColleague(DeviceColleague colleague) {
        colleagues.put(colleague.getClass(), colleague);
    }

    @Override
    public DeviceColleague unregisterColleague(Class<? extends DeviceColleague> colleagueClass) {
        return colleagues.remove(colleagueClass);
    }

    @Override
    public DeviceColleague getColleague(Class<? extends DeviceColleague> colleagueClass) {
        return colleagues.get(colleagueClass);
    }

    @Override
    public void notifyIOReadToColleagues(DeviceColleagueEvent event) {
        for (Map.Entry<Class, DeviceColleague> classDeviceColleagueEntry : colleagues.entrySet()) {
            classDeviceColleagueEntry.getValue().executeIORead(this, event);
        }
    }

    @Override
    public void notifyIOReadToColleague(DeviceColleagueEvent event, Class<? extends DeviceColleague> colleague) {
        getColleague(colleague).executeIORead(this, event);
    }

    @Override
    public void notifyIOWriteToColleagues(DeviceColleagueEvent event) {
        for (Map.Entry<Class, DeviceColleague> classDeviceColleagueEntry : colleagues.entrySet()) {
            classDeviceColleagueEntry.getValue().executeIOWrite(this, event);
        }
    }

    @Override
    public void notifyIOWriteToColleague(DeviceColleagueEvent event, Class<? extends DeviceColleague> colleague) {
        getColleague(colleague).executeIOWrite(this, event);
    }

}
