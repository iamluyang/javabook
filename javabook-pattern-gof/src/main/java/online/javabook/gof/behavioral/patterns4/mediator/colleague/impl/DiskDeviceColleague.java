package online.javabook.gof.behavioral.patterns4.mediator.colleague.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;

public class DiskDeviceColleague extends DeviceColleague {

    @Override
    public void executeIORead(IMediator mediator, DeviceColleagueEvent event) {
        System.out.println("read data from disk");
        String data = "read data from disk";
        mediator.notifyIOReadToColleague(new DeviceColleagueEvent(data), MemoryDeviceColleague.class);
    }

    @Override
    public void executeIOWrite(IMediator mediator, DeviceColleagueEvent event) {
        System.out.println("write data to disk");
    }
}
