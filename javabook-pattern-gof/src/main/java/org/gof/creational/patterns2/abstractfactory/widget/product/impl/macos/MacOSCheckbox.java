package org.gof.creational.patterns2.abstractfactory.widget.product.impl.macos;

import org.gof.creational.patterns2.abstractfactory.widget.product.api.ICheckbox;

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a variant of a checkbox.
 */
public class MacOSCheckbox implements ICheckbox {

    @Override
    public void paint() {
        System.out.println("You have created MacCheckbox.");
    }
}
