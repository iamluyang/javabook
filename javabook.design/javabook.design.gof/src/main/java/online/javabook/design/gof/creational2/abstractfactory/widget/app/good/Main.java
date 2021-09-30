package online.javabook.design.gof.creational2.abstractfactory.widget.app.good;

import online.javabook.design.gof.creational2.abstractfactory.widget.product.api.IGUIFactory;
import online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.macos.MacOSGUIFactory;
import online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.windows.WindowsGUIFactory;

public class Main {

    public static void main(String[] args) {

        // business
        String osName = System.getProperty("os.name").toLowerCase();

        // abstract factory
        IGUIFactory guiFactory;
        if (osName.contains("mac")) {
            guiFactory = new MacOSGUIFactory();
        } else {
            guiFactory = new WindowsGUIFactory();
        }

        // os -> gui factory
        OS os = new OS();
        os.setGuiFactory(guiFactory);

        // do business
        os.drawDesktop();
        os.drawToolbar();
        os.drawBrowser();
    }
}
