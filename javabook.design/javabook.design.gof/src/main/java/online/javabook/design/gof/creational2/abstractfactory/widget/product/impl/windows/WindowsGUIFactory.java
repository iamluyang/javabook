package online.javabook.design.gof.creational2.abstractfactory.widget.product.impl.windows;

import online.javabook.design.gof.creational2.abstractfactory.widget.product.api.IButton;
import online.javabook.design.gof.creational2.abstractfactory.widget.product.api.ICheckbox;
import online.javabook.design.gof.creational2.abstractfactory.widget.product.api.IGUIFactory;
import online.javabook.design.gof.creational2.abstractfactory.widget.product.api.IRadio;

public class WindowsGUIFactory implements IGUIFactory {

    @Override
    public IButton createButton() {
        return new WindowsButton();
    }

    @Override
    public ICheckbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public IRadio createRadio() {
        return new WindowsRadio();
    }
}