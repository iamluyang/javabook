package online.javabook.gof.behavioral.patterns4.mediator.listener.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.CpuDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.DiskDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.MemoryDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DefaultDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueReadEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueWriteEvent;

public class MemoryDeviceColleagueListener extends DefaultDeviceColleagueListener {

    @Override
    public void doMemoryRead(IMediator mediator, DeviceColleagueReadEvent event) {
        mediator.notifyDeviceColleagues(new DeviceColleagueReadEvent(event.getData(), CpuDeviceColleague.class));
    }

    @Override
    public void doMemoryWrite(IMediator mediator, DeviceColleagueWriteEvent event) {
        mediator.notifyDeviceColleagues(new DeviceColleagueWriteEvent(event.getData(), DiskDeviceColleague.class));
    }

}