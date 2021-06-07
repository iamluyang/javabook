package online.javabook.gof.creational.patterns2.abstractfactory.widget.product.impl.macos;

import online.javabook.gof.creational.patterns2.abstractfactory.widget.product.api.ICheckbox;

public class MacOSCheckbox implements ICheckbox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
