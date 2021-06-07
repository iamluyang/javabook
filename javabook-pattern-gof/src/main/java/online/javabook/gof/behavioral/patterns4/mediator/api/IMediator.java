package online.javabook.gof.behavioral.patterns4.mediator.api;

import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;

public interface IMediator {

    void registerColleague(DeviceColleague colleagueClass);

    DeviceColleague unregisterColleague(Class<? extends DeviceColleague> colleagueClass);

    DeviceColleague getColleague(Class<? extends DeviceColleague> colleagueClass);

    public void notifyIOReadToColleagues(DeviceColleagueEvent event);

    public void notifyIOReadToColleague(DeviceColleagueEvent event, Class<? extends DeviceColleague> colleague);

    public void notifyIOWriteToColleagues(DeviceColleagueEvent event);

    public void notifyIOWriteToColleague(DeviceColleagueEvent event, Class<? extends DeviceColleague> colleague);
}
