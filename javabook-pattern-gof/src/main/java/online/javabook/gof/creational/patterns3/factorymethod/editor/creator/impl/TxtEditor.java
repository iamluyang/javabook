package online.javabook.gof.creational.patterns3.factorymethod.editor.creator.impl;

import online.javabook.gof.creational.patterns3.factorymethod.editor.creator.api.Editor;
import online.javabook.gof.creational.patterns3.factorymethod.editor.product.api.Document;
import online.javabook.gof.creational.patterns3.factorymethod.editor.product.impl.TxtDocument;

public class TxtEditor extends Editor {

    protected Document createDocument(String file) {
        Document document = new TxtDocument();
        document.setFile(file);
        return document;
    }
}
