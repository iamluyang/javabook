package online.javabook.pattern.gof.creational.patterns2.abstractfactory.widget.product.api;

public interface IGUIFactory {

    IButton createButton();

    ICheckbox createCheckbox();

    IRadio createRadio();
}