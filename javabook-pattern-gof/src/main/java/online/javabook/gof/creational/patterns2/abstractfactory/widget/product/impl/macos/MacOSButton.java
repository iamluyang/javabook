package online.javabook.gof.creational.patterns2.abstractfactory.widget.product.impl.macos;

import online.javabook.gof.creational.patterns2.abstractfactory.widget.product.api.IButton;

public class MacOSButton implements IButton {

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
