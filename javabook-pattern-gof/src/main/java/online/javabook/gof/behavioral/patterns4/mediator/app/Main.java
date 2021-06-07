package online.javabook.gof.behavioral.patterns4.mediator.app;

import online.javabook.gof.behavioral.patterns4.mediator.api.IMediator;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;
import online.javabook.gof.behavioral.patterns4.mediator.colleague.impl.*;
import online.javabook.gof.behavioral.patterns4.mediator.impl.ComputerMediator;
import online.javabook.gof.behavioral.patterns4.mediator.listener.api.DeviceColleagueEvent;
import online.javabook.gof.behavioral.patterns4.mediator.listener.impl.CpuDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.impl.DiskDeviceColleagueListener;
import online.javabook.gof.behavioral.patterns4.mediator.listener.impl.MemoryDeviceColleagueListener;

public class Main {
    public static void main(String[] args) {
        IMediator mediator = new ComputerMediator();

        // colleagues
        DeviceColleague cpuDeviceColleague = new CpuDeviceColleague();
        cpuDeviceColleague.registerDeviceColleagueListener(new CpuDeviceColleagueListener());

        DeviceColleague memoryDeviceColleague = new MemoryDeviceColleague();
        memoryDeviceColleague.registerDeviceColleagueListener(new MemoryDeviceColleagueListener());

        DeviceColleague diskDeviceColleague = new DiskDeviceColleague();
        diskDeviceColleague.registerDeviceColleagueListener(new DiskDeviceColleagueListener());

        mediator.registerColleague(cpuDeviceColleague);
        mediator.registerColleague(memoryDeviceColleague);
        mediator.registerColleague(diskDeviceColleague);

        // mediator
        DeviceColleague disk = mediator.getColleague(DiskDeviceColleague.class);
        disk.executeIORead(mediator, new DeviceColleagueEvent("read"));

        // write
        DeviceColleague cpu = mediator.getColleague(CpuDeviceColleague.class);
        cpu.executeIOWrite(mediator, new DeviceColleagueEvent("write"));
    }
}
