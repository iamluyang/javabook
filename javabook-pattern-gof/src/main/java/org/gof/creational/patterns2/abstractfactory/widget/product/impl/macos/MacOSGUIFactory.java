package org.gof.creational.patterns2.abstractfactory.widget.product.impl.macos;

import org.gof.creational.patterns2.abstractfactory.widget.product.api.IButton;
import org.gof.creational.patterns2.abstractfactory.widget.product.api.ICheckbox;
import org.gof.creational.patterns2.abstractfactory.widget.product.api.IGUIFactory;
import org.gof.creational.patterns2.abstractfactory.widget.product.api.IRadio;

public class MacOSGUIFactory implements IGUIFactory {

    @Override
    public IButton createButton() {
        return new MacOSButton();
    }

    @Override
    public ICheckbox createCheckbox() {
        return new MacOSCheckbox();
    }

    @Override
    public IRadio createRadio() {
        return new MacOSRadio();
    }
}
