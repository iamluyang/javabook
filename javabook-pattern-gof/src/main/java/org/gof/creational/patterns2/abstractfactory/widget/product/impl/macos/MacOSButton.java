package org.gof.creational.patterns2.abstractfactory.widget.product.impl.macos;

import org.gof.creational.patterns2.abstractfactory.widget.product.api.IButton;

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a MacOS variant of a button.
 */
public class MacOSButton implements IButton {

    @Override
    public void paint() {
        System.out.println("You have created MacButton.");
    }
}
