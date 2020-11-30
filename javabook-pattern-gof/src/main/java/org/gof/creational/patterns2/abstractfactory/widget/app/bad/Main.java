package org.gof.creational.patterns2.abstractfactory.widget.app.bad;

public class Main {

    public static void main(String[] args) {

        // changing business
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
