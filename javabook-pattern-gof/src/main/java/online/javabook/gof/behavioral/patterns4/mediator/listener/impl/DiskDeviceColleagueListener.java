package online.javabook.gof.behavioral.patterns4.mediator.listener.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.MemoryDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DefaultDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueReadEvent;

public class DiskDeviceColleagueListener extends DefaultDeviceColleagueListener {

    @Override
    public void doDiskRead(IMediator mediator, DeviceColleagueReadEvent event) {
        mediator.notifyDeviceColleagues(new DeviceColleagueReadEvent(event.getData(), MemoryDeviceColleague.class));
    }
}