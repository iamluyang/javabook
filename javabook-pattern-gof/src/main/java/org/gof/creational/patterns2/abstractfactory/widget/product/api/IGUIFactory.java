package org.gof.creational.patterns2.abstractfactory.widget.product.api;

/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface IGUIFactory {

    IButton createButton();

    ICheckbox createCheckbox();

    IRadio createRadio();
}