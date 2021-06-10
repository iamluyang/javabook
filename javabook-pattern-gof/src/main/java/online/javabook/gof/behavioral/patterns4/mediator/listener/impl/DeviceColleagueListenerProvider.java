package online.javabook.gof.behavioral.patterns4.mediator.listener.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueReadEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueWriteEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListenerProvider;

import java.util.ArrayList;
import java.util.List;

public class DeviceColleagueListenerProvider implements IDeviceColleagueListenerProvider {

    private IMediator mediator;

    private List<IDeviceColleagueListener> deviceColleagueListeners = new ArrayList<>();

    public DeviceColleagueListenerProvider(IMediator mediator) {
        this.mediator = mediator;
    }

    public List<IDeviceColleagueListener> getDeviceColleagueListeners() {
        return deviceColleagueListeners;
    }

    public void registerDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener) {
        this.deviceColleagueListeners.add(deviceColleagueListener);
    }

    public void unregisterDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener) {
        this.deviceColleagueListeners.remove(deviceColleagueListener);
    }

    @Override
    public void doCpuRead(DeviceColleagueReadEvent event) {
        for (IDeviceColleagueListener deviceColleagueListener : deviceColleagueListeners) {
            deviceColleagueListener.doCpuRead(mediator, event);
        }
    }

    @Override
    public void doCpuWrite(DeviceColleagueWriteEvent event) {
        for (IDeviceColleagueListener deviceColleagueListener : deviceColleagueListeners) {
            deviceColleagueListener.doCpuWrite(mediator, event);
        }
    }

    @Override
    public void doMemoryRead(DeviceColleagueReadEvent event) {
        for (IDeviceColleagueListener deviceColleagueListener : deviceColleagueListeners) {
            deviceColleagueListener.doMemoryRead(mediator, event);
        }
    }

    @Override
    public void doMemoryWrite(DeviceColleagueWriteEvent event) {
        for (IDeviceColleagueListener deviceColleagueListener : deviceColleagueListeners) {
            deviceColleagueListener.doMemoryWrite(mediator, event);
        }
    }

    @Override
    public void doDiskRead(DeviceColleagueReadEvent event) {
        for (IDeviceColleagueListener deviceColleagueListener : deviceColleagueListeners) {
            deviceColleagueListener.doDiskRead(mediator, event);
        }
    }

    @Override
    public void doDiskWrite(DeviceColleagueWriteEvent event) {
        for (IDeviceColleagueListener deviceColleagueListener : deviceColleagueListeners) {
            deviceColleagueListener.doDiskWrite(mediator, event);
        }
    }
}