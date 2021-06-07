package online.javabook.gof.behavioral.patterns4.mediator.listener.impl;

import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListenerProvider;

import java.util.ArrayList;
import java.util.List;

public class DeviceColleagueListenerProvider implements IDeviceColleagueListenerProvider {

    private List<IDeviceColleagueListener> serviceBusListeners = new ArrayList<>();

    public List<IDeviceColleagueListener> getServiceBusListeners() {
        return serviceBusListeners;
    }

    public void registerServiceBusListener(IDeviceColleagueListener serviceBusListener) {
        this.serviceBusListeners.add(serviceBusListener);
    }

    public void unregisterServiceBusListener(IDeviceColleagueListener serviceBusListener) {
        this.serviceBusListeners.remove(serviceBusListener);
    }

    public void doIORead(String data) {
        for (IDeviceColleagueListener serviceBusListener : serviceBusListeners) {
            serviceBusListener.doIORead(new DeviceColleagueEvent(data));
        }
    }

    public void doIOWrite(String data) {
        for (IDeviceColleagueListener serviceBusListener : serviceBusListeners) {
            serviceBusListener.doIOWrite(new DeviceColleagueEvent(data));
        }
    }
}
