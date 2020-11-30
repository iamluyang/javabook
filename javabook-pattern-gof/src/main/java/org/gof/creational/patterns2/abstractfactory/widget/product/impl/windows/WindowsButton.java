package org.gof.creational.patterns2.abstractfactory.widget.product.impl.windows;

import org.gof.creational.patterns2.abstractfactory.widget.product.api.IButton;

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is another variant of a button.
 */
public class WindowsButton implements IButton {

    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}