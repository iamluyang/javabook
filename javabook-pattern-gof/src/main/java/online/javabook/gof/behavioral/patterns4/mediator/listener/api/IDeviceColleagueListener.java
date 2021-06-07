package online.javabook.gof.behavioral.patterns4.mediator.listener.api;

public interface IDeviceColleagueListener {

    void doIORead(DeviceColleagueEvent event);

    void doIOWrite(DeviceColleagueEvent event);
}
