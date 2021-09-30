package online.javabook.design.gof.behavioral4.mediator.listener.impl;

import online.javabook.design.gof.behavioral4.mediator.colleague.impl.MemoryDeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.api.IMediator;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DefaultDeviceColleagueListener;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DeviceColleagueReadEvent;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DeviceColleagueWriteEvent;

public class MemoryDeviceColleagueListener extends DefaultDeviceColleagueListener {

    @Override
    public void doDiskRead(IMediator mediator, DeviceColleagueReadEvent event) {
        System.out.println("我是Memory，我收到Disk读取的数据" + event.getData());
        mediator.doRead(MemoryDeviceColleague.class, event.getData());
    }

    @Override
    public void doCpuWrite(IMediator mediator, DeviceColleagueWriteEvent event) {
        System.out.println("我是Memory，我收到CPU写入的数据" + event.getData());
        mediator.doWrite(MemoryDeviceColleague.class, event.getData());
    }
}