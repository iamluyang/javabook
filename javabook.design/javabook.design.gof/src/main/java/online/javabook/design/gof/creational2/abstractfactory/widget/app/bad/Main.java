package online.javabook.design.gof.creational2.abstractfactory.widget.app.bad;

public class Main {

    public static void main(String[] args) {

        String osName = System.getProperty("os.name").toLowerCase();

        // os
        OS os = new OS();
        os.setOsName(osName);

        // do business
        os.drawDesktop();
        os.drawToolbar();
        os.drawBrowser();
    }
}
