package online.javabook.gof.behavioral.patterns4.mediator.listener.impl;

import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.IDeviceColleagueListener;

public class MemoryDeviceColleagueListener implements IDeviceColleagueListener {

    @Override
    public void doIORead(DeviceColleagueEvent event) {
        System.out.println(this.getClass().getName()+":"+"doIORead");
    }

    @Override
    public void doIOWrite(DeviceColleagueEvent event) {
        System.out.println(this.getClass().getName()+":"+"doIOWrite");
    }
}
