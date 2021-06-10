package online.javabook.gof.behavioral.patterns4.mediator.app;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.CpuDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.DiskDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.MemoryDeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.impl.ComputerMediator;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueReadEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueWriteEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.impl.CpuDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.impl.DiskDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.impl.MemoryDeviceColleagueListener;

public class Main {
    public static void main(String[] args) {
        IMediator mediator = new ComputerMediator();

        // colleagues
        mediator.registerDeviceColleague(new CpuDeviceColleague());
        mediator.registerDeviceColleague(new MemoryDeviceColleague());
        mediator.registerDeviceColleague(new DiskDeviceColleague());

        // listeners
        mediator.registerDeviceColleagueListener(new MemoryDeviceColleagueListener());
        mediator.registerDeviceColleagueListener(new CpuDeviceColleagueListener());
        mediator.registerDeviceColleagueListener(new DiskDeviceColleagueListener());

        // mediator
        mediator.notifyDeviceColleagues(new DeviceColleagueReadEvent("rrr", DiskDeviceColleague.class));

        System.out.println("--------------------------------");

        // write
        mediator.notifyDeviceColleagues(new DeviceColleagueWriteEvent("www", CpuDeviceColleague.class));

    }
}