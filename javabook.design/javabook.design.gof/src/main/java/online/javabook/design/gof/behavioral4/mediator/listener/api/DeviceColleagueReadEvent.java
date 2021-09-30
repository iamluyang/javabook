package online.javabook.design.gof.behavioral4.mediator.listener.api;

import online.javabook.design.gof.behavioral4.mediator.colleague.api.DeviceColleague;

public class DeviceColleagueReadEvent extends DeviceColleagueEvent {

    public DeviceColleagueReadEvent(String data, Class<? extends DeviceColleague> deviceColleagueClass) {
        super(data, deviceColleagueClass);
    }
}