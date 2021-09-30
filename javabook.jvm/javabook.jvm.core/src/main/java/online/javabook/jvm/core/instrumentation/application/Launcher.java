package online.javabook.jvm.core.instrumentation.application;

public class Launcher {

    public static void main(String[] args) throws Exception {
        if(args[0].equals("StartMyAtmApplication")) {
            new MyAtmApplication().run(args);

        } else if(args[0].equals("LoadAgent")) {
            new AgentLoader().run(args);

        }
    }
}
