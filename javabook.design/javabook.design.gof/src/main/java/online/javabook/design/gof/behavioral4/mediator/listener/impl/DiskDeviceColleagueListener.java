package online.javabook.design.gof.behavioral4.mediator.listener.impl;

import online.javabook.design.gof.behavioral4.mediator.api.IMediator;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DefaultDeviceColleagueListener;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DeviceColleagueWriteEvent;

public class DiskDeviceColleagueListener extends DefaultDeviceColleagueListener {

    @Override
    public void doMemoryWrite(IMediator mediator, DeviceColleagueWriteEvent event) {
        System.out.println("我是Disk，我收到Memory写入的数据" + event.getData());
    }
}