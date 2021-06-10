package online.javabook.gof.behavioral.patterns4.mediator.colleague.impl;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueReadEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueWriteEvent;

public class DiskDeviceColleague extends DeviceColleague {

    @Override
    public String doRead(IMediator mediator, DeviceColleagueReadEvent event) {
        String data = "call disk read data<-" + event.getData();
        System.out.println(data);
        return data;
    }

    @Override
    public String doWrite(IMediator mediator, DeviceColleagueWriteEvent event) {
        String data = event.getData() + "->" + "call disk write data";
        System.out.println(data);
        return data;
    }
}