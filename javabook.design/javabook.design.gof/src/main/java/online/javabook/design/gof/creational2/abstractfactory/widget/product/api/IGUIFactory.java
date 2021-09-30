package online.javabook.design.gof.creational2.abstractfactory.widget.product.api;

public interface IGUIFactory {

    IButton createButton();

    ICheckbox createCheckbox();

    IRadio createRadio();
}