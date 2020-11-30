package org.gof.creational.patterns2.abstractfactory.widget.product.impl.windows;

import org.gof.creational.patterns2.abstractfactory.widget.product.api.ICheckbox;

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is another variant of a checkbox.
 */
public class WindowsCheckbox implements ICheckbox {

    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}
