package online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.macos;

import online.javabook.design.gof.creational2.abstractfactory.widget.product.api.ICheckbox;

public class MacOSCheckbox implements ICheckbox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
