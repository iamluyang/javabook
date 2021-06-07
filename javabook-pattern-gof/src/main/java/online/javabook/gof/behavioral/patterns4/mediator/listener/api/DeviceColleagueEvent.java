package online.javabook.gof.behavioral.patterns4.mediator.listener.api;

public class DeviceColleagueEvent {

    public String data;

    public DeviceColleagueEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
