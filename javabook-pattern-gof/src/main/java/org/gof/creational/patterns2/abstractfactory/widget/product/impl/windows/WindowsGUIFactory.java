package org.gof.creational.patterns2.abstractfactory.widget.product.impl.windows;

import org.gof.creational.patterns2.abstractfactory.widget.product.api.IButton;
import org.gof.creational.patterns2.abstractfactory.widget.product.api.ICheckbox;
import org.gof.creational.patterns2.abstractfactory.widget.product.api.IGUIFactory;
import org.gof.creational.patterns2.abstractfactory.widget.product.api.IRadio;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
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