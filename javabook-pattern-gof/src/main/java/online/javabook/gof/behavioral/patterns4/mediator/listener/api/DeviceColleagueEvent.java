package online.javabook.gof.behavioral.patterns4.mediator.listener.api;

import online.javabook.gof.behavioral.patterns4.mediator.colleague.api.DeviceColleague;

public class DeviceColleagueEvent {

    private String data;

    private Class<? extends DeviceColleague> deviceColleagueClass;

    public DeviceColleagueEvent(String data, Class<? extends DeviceColleague> deviceColleagueClass) {
        this.data = data;
        this.deviceColleagueClass = deviceColleagueClass;
    }

    public String getData() {
        return data;
    }

    public Class<? extends DeviceColleague> getDeviceColleague() {
        return deviceColleagueClass;
    }
}