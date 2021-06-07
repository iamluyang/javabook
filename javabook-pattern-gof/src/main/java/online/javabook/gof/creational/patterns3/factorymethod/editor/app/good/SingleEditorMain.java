package online.javabook.gof.creational.patterns3.factorymethod.editor.app.good;

import online.javabook.gof.creational.patterns3.factorymethod.editor.creator.api.Editor;
import online.javabook.gof.creational.patterns3.factorymethod.editor.creator.impl.PdfEditor;
import online.javabook.gof.creational.patterns3.factorymethod.editor.creator.impl.PngEditor;
import online.javabook.gof.creational.patterns3.factorymethod.editor.creator.impl.TxtEditor;

public class SingleEditorMain {
    public static void main(String[] args) {

        // product
        String fileName = "*.txt";

        // factory
        Editor editor = null;
        if (fileName.endsWith(".txt")) {
            editor = new TxtEditor();

        } else if (fileName.endsWith(".pdf")) {
            editor = new PdfEditor();

        }else if (fileName.endsWith(".png")) {
            editor = new PngEditor();
        }

        // do business
        editor.open("file1.txt");
        editor.open("file2.txt");
        editor.open("file3.txt");

        System.out.println("最后一次打开的文件:" +editor.getTitle());
        editor.saveAll();
        editor.closeAll();
    }
}
