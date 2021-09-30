package online.javabook.design.gof.behavioral4.mediator.listener.impl;

import online.javabook.design.gof.behavioral4.mediator.api.IMediator;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DefaultDeviceColleagueListener;
import online.javabook.design.gof.behavioral4.mediator.listener.api.DeviceColleagueReadEvent;

public class CpuDeviceColleagueListener extends DefaultDeviceColleagueListener {

    @Override
    public void doMemoryRead(IMediator mediator, DeviceColleagueReadEvent event) {
        System.out.println("我是CPU，我收到Memory读取的数据" + event.getData());
    }
}