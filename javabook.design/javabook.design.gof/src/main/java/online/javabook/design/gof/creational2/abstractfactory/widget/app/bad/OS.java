package online.javabook.design.gof.creational2.abstractfactory.widget.app.bad;

import online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.macos.MacOSButton;
import online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.macos.MacOSCheckbox;
import online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.windows.WindowsButton;
import online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.windows.WindowsCheckbox;

public class OS {

    private String osName;

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public void drawDesktop(){
        if(osName.equals("windows")) {
            new WindowsButton().paint();
            new WindowsCheckbox().paint();
        }
        else{
            new MacOSButton().paint();
            new MacOSCheckbox().paint();
        }
    }

    public void drawToolbar(){
        if(osName.equals("windows")) {
            new WindowsButton().paint();
            new WindowsCheckbox().paint();
        }
        else{
            new MacOSButton().paint();
            new MacOSCheckbox().paint();
        }
    }

    public void drawBrowser(){
        if(osName.equals("windows")) {
            new WindowsButton().paint();
            new WindowsCheckbox().paint();
        }
        else{
            new MacOSButton().paint();
            new MacOSCheckbox().paint();
        }
    }
}
