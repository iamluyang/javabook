package online.javabook.gof.behavioral.patterns4.mediator.colleague.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;

public class MemoryDeviceColleague extends DeviceColleague {

    @Override
    public void executeIORead(IMediator mediator, DeviceColleagueEvent event) {
        System.out.println("read data from memory");
        String data = "read data from memory";
        mediator.notifyIOReadToColleague(new DeviceColleagueEvent(data), CpuDeviceColleague.class);
    }

    @Override
    public void executeIOWrite(IMediator mediator, DeviceColleagueEvent event) {
        System.out.println("write data to memory");
        String data = "write data to memory";
        mediator.notifyIOWriteToColleague(new DeviceColleagueEvent(data), DiskDeviceColleague.class);
    }
}
