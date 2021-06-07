package online.javabook.gof.creational.patterns3.factorymethod.editor.product.api;

public abstract class Document {

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public abstract void open();

    public abstract void display();

    public abstract void save();

    public abstract void close();
}
