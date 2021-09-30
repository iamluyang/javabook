package online.javabook.design.gof.creational3.factorymethod.editor.creator.impl;

import online.javabook.design.gof.creational3.factorymethod.editor.product.api.Document;
import online.javabook.design.gof.creational3.factorymethod.editor.product.impl.TxtDocument;
import online.javabook.design.gof.creational3.factorymethod.editor.creator.api.Editor;

public class TxtEditor extends Editor {

    protected Document createDocument(String file) {
        Document document = new TxtDocument();
        document.setFile(file);
        return document;
    }
}
