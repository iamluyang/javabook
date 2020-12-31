package org.gof.creational.patterns3.factorymethod.editor.app.good;

import org.gof.creational.patterns3.factorymethod.editor.creator.impl.MultiEditor;
import org.gof.creational.patterns3.factorymethod.editor.product.impl.PdfDocument;
import org.gof.creational.patterns3.factorymethod.editor.product.impl.PngDocument;
import org.gof.creational.patterns3.factorymethod.editor.product.impl.TxtDocument;

public class MultiEditorMain {
    public static void main(String[] args) {

        // factory
        MultiEditor editor = new MultiEditor();
        editor.registerDocumentClass("txt", TxtDocument.class);
        editor.registerDocumentClass("pdf", PdfDocument.class);
        editor.registerDocumentClass("png", PngDocument.class);

        // do business
        editor.open("file1.txt");
        editor.open("file2.pdf");
        editor.open("file3.png");

        System.out.println("最后一次打开的文件:" +editor.getTitle());
        editor.saveAll();
        editor.closeAll();
    }
}
