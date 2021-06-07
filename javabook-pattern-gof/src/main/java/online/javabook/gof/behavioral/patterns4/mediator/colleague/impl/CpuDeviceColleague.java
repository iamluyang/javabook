package online.javabook.gof.behavioral.patterns4.mediator.colleague.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;

public class CpuDeviceColleague extends DeviceColleague {

    @Override
    public void executeIORead(IMediator mediator, DeviceColleagueEvent event) {
        System.out.println("read data from cpu");
        String data = "read data from cpu";
    }

    @Override
    public void executeIOWrite(IMediator mediator, DeviceColleagueEvent event) {
        System.out.println("write data to cpu");
        String data = "write data to cpu";
        mediator.notifyIOWriteToColleague(new DeviceColleagueEvent(data), MemoryDeviceColleague.class);
    }
}
