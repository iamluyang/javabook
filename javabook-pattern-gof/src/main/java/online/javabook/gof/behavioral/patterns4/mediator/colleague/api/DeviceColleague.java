package online.javabook.gof.behavioral.patterns4.mediator.colleague.api;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListenerProvider;
import online.javabook.gof.behavioral.patterns4.mediator.listener.impl.DeviceColleagueListenerProvider;

public abstract class DeviceColleague {

    private IDeviceColleagueListenerProvider provider = new DeviceColleagueListenerProvider();

    public void registerDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener) {
        provider.registerServiceBusListener(deviceColleagueListener);
    }

    public void unregisterDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener) {
        provider.unregisterServiceBusListener(deviceColleagueListener);
    }

    public abstract void executeIORead(IMediator mediator, DeviceColleagueEvent event);

    public abstract void executeIOWrite(IMediator mediator, DeviceColleagueEvent event);

}
