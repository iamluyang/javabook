package online.javabook.design.gof.behavioral4.mediator.app;

import online.javabook.design.gof.behavioral4.mediator.api.IMediator;
import online.javabook.design.gof.behavioral4.mediator.colleague.impl.CpuDeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.colleague.impl.DiskDeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.colleague.impl.MemoryDeviceColleague;
import online.javabook.design.gof.behavioral4.mediator.impl.ComputerMediator;
import online.javabook.design.gof.behavioral4.mediator.listener.impl.CpuDeviceColleagueListener;
import online.javabook.design.gof.behavioral4.mediator.listener.impl.DiskDeviceColleagueListener;
import online.javabook.design.gof.behavioral4.mediator.listener.impl.MemoryDeviceColleagueListener;

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
        mediator.doRead(DiskDeviceColleague.class, "rrr");

        System.out.println("--------------------------------");

        // write
        mediator.doWrite(CpuDeviceColleague.class, "www");

    }
}