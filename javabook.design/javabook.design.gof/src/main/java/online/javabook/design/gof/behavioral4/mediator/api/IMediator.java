package online.javabook.design.gof.behavioral4.mediator.api;

import online.javabook.design.gof.behavioral4.mediator.colleague.api.DeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.listener.api.IDeviceColleagueListener;
import online.javabook.design.gof.behavioral4.mediator.listener.api.IDeviceColleagueListenerProvider;

public interface IMediator {

    DeviceColleague getColleague(Class<? extends DeviceColleague> colleagueClass);

    void registerDeviceColleague(DeviceColleague colleagueClass);

    void unregisterDeviceColleague(Class<? extends DeviceColleague> colleagueClass);

    IDeviceColleagueListenerProvider getProvider();

    void registerDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener);

    void unregisterDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener);

    void doRead(Class<? extends DeviceColleague> colleagueClass, String readDate);

    void doWrite(Class<? extends DeviceColleague> colleagueClass, String writeData);
}