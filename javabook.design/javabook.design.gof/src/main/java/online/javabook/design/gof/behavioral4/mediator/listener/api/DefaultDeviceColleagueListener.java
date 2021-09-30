package online.javabook.design.gof.behavioral4.mediator.listener.api;

import online.javabook.design.gof.behavioral4.mediator.api.IMediator;

public class DefaultDeviceColleagueListener implements IDeviceColleagueListener {

    @Override
    public void doCpuRead(IMediator mediator, DeviceColleagueReadEvent event) {
    }

    @Override
    public void doCpuWrite(IMediator mediator, DeviceColleagueWriteEvent event) {
    }

    @Override
    public void doMemoryRead(IMediator mediator, DeviceColleagueReadEvent event) {
    }

    @Override
    public void doMemoryWrite(IMediator mediator, DeviceColleagueWriteEvent event) {
    }

    @Override
    public void doDiskRead(IMediator mediator, DeviceColleagueReadEvent event) {
    }

    @Override
    public void doDiskWrite(IMediator mediator, DeviceColleagueWriteEvent event) {
    }
}