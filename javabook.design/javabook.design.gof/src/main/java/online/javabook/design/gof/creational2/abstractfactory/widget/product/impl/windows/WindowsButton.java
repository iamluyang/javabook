package online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.windows;

import online.javabook.design.gof.creational2.abstractfactory.widget.product.api.IButton;

public class WindowsButton implements IButton {

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}