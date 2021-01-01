package online.javabook.pattern.gof.creational.patterns2.abstractfactory.widget.product.impl.windows;

import online.javabook.pattern.gof.creational.patterns2.abstractfactory.widget.product.api.IRadio;

public class WindowsRadio implements IRadio {

    @Override
    public void paint() {
        System.out.println("You have created WindowsRadio.");
    }
}
