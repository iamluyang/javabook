package online.javabook.gof.behavioral.patterns4.mediator.impl;

import java.util.HashMap;
import java.util.Map;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.CpuDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.DiskDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.MemoryDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueReadEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueWriteEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListenerProvider;
import online.javabook.gof.behavioral.patterns4.mediator.listener.impl.DeviceColleagueListenerProvider;

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
    public void notifyDeviceColleagues(DeviceColleagueEvent event) {

        // read
        String data = null;
        if(event.getDeviceColleague().equals(DiskDeviceColleague.class)  && event instanceof DeviceColleagueReadEvent) {
            data = getColleague(event.getDeviceColleague()).doRead(this, (DeviceColleagueReadEvent) event);
            getProvider().doDiskRead(new DeviceColleagueReadEvent(data, DiskDeviceColleague.class));

        } else if(event.getDeviceColleague().equals(MemoryDeviceColleague.class) && event instanceof DeviceColleagueReadEvent) {
            data = getColleague(event.getDeviceColleague()).doRead(this, (DeviceColleagueReadEvent) event);
            getProvider().doMemoryRead(new DeviceColleagueReadEvent(data, MemoryDeviceColleague.class));

        } else if(event.getDeviceColleague().equals(CpuDeviceColleague.class) && event instanceof DeviceColleagueReadEvent) {
            data = getColleague(event.getDeviceColleague()).doRead(this, (DeviceColleagueReadEvent) event);
            getProvider().doCpuRead(new DeviceColleagueReadEvent(data, CpuDeviceColleague.class));

        }

        // write
        if(event.getDeviceColleague().equals(DiskDeviceColleague.class) && event instanceof DeviceColleagueWriteEvent) {
            data = getColleague(event.getDeviceColleague()).doWrite(this, (DeviceColleagueWriteEvent) event);
            getProvider().doDiskWrite(new DeviceColleagueWriteEvent(data, DiskDeviceColleague.class));

        }else if(event.getDeviceColleague().equals(MemoryDeviceColleague.class) && event instanceof DeviceColleagueWriteEvent) {
            data = getColleague(event.getDeviceColleague()).doWrite(this, (DeviceColleagueWriteEvent) event);
            getProvider().doMemoryWrite(new DeviceColleagueWriteEvent(data, MemoryDeviceColleague.class));

        } else if(event.getDeviceColleague().equals(CpuDeviceColleague.class) && event instanceof DeviceColleagueWriteEvent) {
            data = getColleague(event.getDeviceColleague()).doWrite(this, (DeviceColleagueWriteEvent) event);
            getProvider().doCpuWrite(new DeviceColleagueWriteEvent(data, CpuDeviceColleague.class));

        }
    }
}