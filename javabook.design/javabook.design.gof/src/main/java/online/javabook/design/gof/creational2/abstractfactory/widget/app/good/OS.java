package online.javabook.design.gof.creational2.abstractfactory.widget.app.good;

import online.javabook.design.gof.creational2.abstractfactory.widget.product.api.IGUIFactory;

public class OS {

    private IGUIFactory guiFactory;

    public IGUIFactory getGuiFactory() {
        return guiFactory;
    }

    public void setGuiFactory(IGUIFactory guiFactory) {
        this.guiFactory = guiFactory;
    }

    public void drawDesktop(){
        getGuiFactory().createButton().paint();
        getGuiFactory().createCheckbox().paint();
    }

    public void drawToolbar(){
        getGuiFactory().createButton().paint();
        getGuiFactory().createCheckbox().paint();
    }

    public void drawBrowser(){
        getGuiFactory().createButton().paint();
        getGuiFactory().createCheckbox().paint();
    }
}
