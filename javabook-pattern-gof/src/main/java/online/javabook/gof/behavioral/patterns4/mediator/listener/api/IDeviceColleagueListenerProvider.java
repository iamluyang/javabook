package online.javabook.gof.behavioral.patterns4.mediator.listener.api;

import java.util.List;

public interface IDeviceColleagueListenerProvider {

    List<IDeviceColleagueListener> getDeviceColleagueListeners();

    void registerDeviceColleagueListener(IDeviceColleagueListener serviceBusListener);

    void unregisterDeviceColleagueListener(IDeviceColleagueListener serviceBusListener);

    void doCpuRead(DeviceColleagueReadEvent event);

    void doCpuWrite(DeviceColleagueWriteEvent event);

    void doMemoryRead(DeviceColleagueReadEvent event);

    void doMemoryWrite(DeviceColleagueWriteEvent event);

    void doDiskRead(DeviceColleagueReadEvent event);

    void doDiskWrite(DeviceColleagueWriteEvent event);
}