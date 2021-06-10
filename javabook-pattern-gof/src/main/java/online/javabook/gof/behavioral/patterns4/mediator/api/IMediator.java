package online.javabook.gof.behavioral.patterns4.mediator.api;

import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListenerProvider;

public interface IMediator {

    DeviceColleague getColleague(Class<? extends DeviceColleague> colleagueClass);

    void registerDeviceColleague(DeviceColleague colleagueClass);

    void unregisterDeviceColleague(Class<? extends DeviceColleague> colleagueClass);

    IDeviceColleagueListenerProvider getProvider();

    void registerDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener);

    void unregisterDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener);

    void notifyDeviceColleagues(DeviceColleagueEvent event);
}