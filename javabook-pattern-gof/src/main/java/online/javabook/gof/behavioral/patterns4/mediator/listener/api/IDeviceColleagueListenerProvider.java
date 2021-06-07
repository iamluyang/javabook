package online.javabook.gof.behavioral.patterns4.mediator.listener.api;

import java.util.List;

public interface IDeviceColleagueListenerProvider {

    List<IDeviceColleagueListener> getServiceBusListeners();

    void registerServiceBusListener(IDeviceColleagueListener serviceBusListener);

    void unregisterServiceBusListener(IDeviceColleagueListener serviceBusListener);

    void doIORead(String data);

    void doIOWrite(String data);
}
