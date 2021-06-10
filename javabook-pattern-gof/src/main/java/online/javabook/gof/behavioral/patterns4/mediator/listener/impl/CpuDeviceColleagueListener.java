package online.javabook.gof.behavioral.patterns4.mediator.listener.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.MemoryDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DefaultDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueWriteEvent;

public class CpuDeviceColleagueListener extends DefaultDeviceColleagueListener {

    @Override
    public void doCpuWrite(IMediator mediator, DeviceColleagueWriteEvent event) {
        mediator.notifyDeviceColleagues(new DeviceColleagueWriteEvent(event.getData(), MemoryDeviceColleague.class));
    }
}