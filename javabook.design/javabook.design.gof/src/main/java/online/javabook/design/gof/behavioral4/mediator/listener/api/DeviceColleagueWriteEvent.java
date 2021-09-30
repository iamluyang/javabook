package online.javabook.design.gof.behavioral4.mediator.listener.api;

import online.javabook.design.gof.behavioral4.mediator.colleague.api.DeviceColleague;

public class DeviceColleagueWriteEvent extends DeviceColleagueEvent {

    public DeviceColleagueWriteEvent(String data, Class<? extends DeviceColleague> deviceColleagueClass) {
        super(data, deviceColleagueClass);
    }
}