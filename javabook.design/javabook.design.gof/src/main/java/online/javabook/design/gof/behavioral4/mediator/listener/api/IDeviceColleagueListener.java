package online.javabook.design.gof.behavioral4.mediator.listener.api;

import online.javabook.design.gof.behavioral4.mediator.api.IMediator;

public interface IDeviceColleagueListener {

    void doCpuRead(IMediator mediator, DeviceColleagueReadEvent event);

    void doCpuWrite(IMediator mediator, DeviceColleagueWriteEvent event);

    void doMemoryRead(IMediator mediator, DeviceColleagueReadEvent event);

    void doMemoryWrite(IMediator mediator, DeviceColleagueWriteEvent event);

    void doDiskRead(IMediator mediator, DeviceColleagueReadEvent event);

    void doDiskWrite(IMediator mediator, DeviceColleagueWriteEvent event);
}