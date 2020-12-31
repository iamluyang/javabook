package org.gof.creational.patterns2.abstractfactory.widget.product.impl.macos;

import org.gof.creational.patterns2.abstractfactory.widget.product.api.IRadio;

public class MacOSRadio implements IRadio {
    @Override
    public void paint() {
        System.out.println("You have created MacOSRadio.");
    }
}
