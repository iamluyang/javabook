package online.javabook.design.gof.behavioral4.mediator.impl;

import online.javabook.design.gof.behavioral4.mediator.colleague.api.DeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.colleague.impl.CpuDeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.colleague.impl.DiskDeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.colleague.impl.MemoryDeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DeviceColleagueReadEvent;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DeviceColleagueWriteEvent;
import online.javabook.design.gof.behavioral4.mediator.listener.api.IDeviceColleagueListener;
import online.javabook.design.gof.behavioral4.mediator.listener.api.IDeviceColleagueListenerProvider;
import online.javabook.design.gof.behavioral4.mediator.listener.impl.DeviceColleagueListenerProvider;
import online.javabook.design.gof.behavioral4.mediator.api.IMediator;

import java.util.HashMap;
import java.util.Map;

public class ComputerMediator implements IMediator {

    private Map<Class, DeviceColleague> colleagues;

    private IDeviceColleagueListenerProvider provider;

    public ComputerMediator() {
        this.colleagues = new HashMap<>();
        this.provider = new DeviceColleagueListenerProvider(this);
    }

    @Override
    public DeviceColleague getColleague(Class<? extends DeviceColleague> colleagueClass) {
        return colleagues.get(colleagueClass);
    }

    @Override
    public void registerDeviceColleague(DeviceColleague colleague) {
        colleagues.put(colleague.getClass(), colleague);
    }

    @Override
    public void unregisterDeviceColleague(Class<? extends DeviceColleague> colleagueClass) {
        colleagues.remove(colleagueClass);
    }

    @Override
    public IDeviceColleagueListenerProvider getProvider() {
        return provider;
    }

    @Override
    public void registerDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener) {
        provider.registerDeviceColleagueListener(deviceColleagueListener);
    }

    @Override
    public void unregisterDeviceColleagueListener(IDeviceColleagueListener deviceColleagueListener) {
        provider.unregisterDeviceColleagueListener(deviceColleagueListener);
    }

    @Override
    public void doRead(Class<? extends DeviceColleague> colleagueClass, String readDate) {
        DeviceColleagueReadEvent event = new DeviceColleagueReadEvent(readDate, colleagueClass);
        getColleague(colleagueClass).doRead(this, event);

        if(colleagueClass.equals(CpuDeviceColleague.class)) {
            getProvider().doCpuRead(event);

        } else if(colleagueClass.equals(MemoryDeviceColleague.class)) {
            getProvider().doMemoryRead(event);

        } else if(colleagueClass.equals(DiskDeviceColleague.class)) {
            getProvider().doDiskRead(event);
        }
    }

    @Override
    public void doWrite(Class<? extends DeviceColleague> colleagueClass, String writeData) {
        DeviceColleagueWriteEvent event = new DeviceColleagueWriteEvent(writeData, colleagueClass);
        getColleague(colleagueClass).doWrite(this, event);

        if(colleagueClass.equals(CpuDeviceColleague.class)) {
            getProvider().doCpuWrite(event);

        } else if(colleagueClass.equals(MemoryDeviceColleague.class)) {
            getProvider().doMemoryWrite(event);

        } else if(colleagueClass.equals(DiskDeviceColleague.class)) {
            getProvider().doDiskWrite(event);
        }
    }
}