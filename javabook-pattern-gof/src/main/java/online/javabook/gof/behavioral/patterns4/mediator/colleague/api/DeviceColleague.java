package online.javabook.gof.behavioral.patterns4.mediator.colleague.api;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueReadEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueWriteEvent;

public abstract class DeviceColleague {

    public abstract String doRead(IMediator mediator, DeviceColleagueReadEvent event);

    public abstract String doWrite(IMediator mediator, DeviceColleagueWriteEvent event);

}