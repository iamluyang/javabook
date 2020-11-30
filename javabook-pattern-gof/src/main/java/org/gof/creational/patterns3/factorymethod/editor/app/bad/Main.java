package org.gof.creational.patterns3.factorymethod.editor.app.bad;

import org.gof.creational.patterns3.factorymethod.editor.creator.api.Editor;
import org.gof.creational.patterns3.factorymethod.editor.creator.impl.PdfEditor;
import org.gof.creational.patterns3.factorymethod.editor.creator.impl.PngEditor;
import org.gof.creational.patterns3.factorymethod.editor.creator.impl.TxtEditor;

public class Main {
    public static void main(String[] args) {

        // business
        String fileName = "myfile.txt";

        // factory method
        Editor editor = null;
        if (fileName.endsWith(".txt")) {
            editor = new TxtEditor();

        } else if (fileName.endsWith(".pdf")) {
            editor = new PdfEditor();

        }else if (fileName.endsWith(".png")) {
            editor = new PngEditor();
        }

        // do business
        editor.open(fileName);
        System.out.println(editor.getTitle());
        editor.save();
        editor.close();
    }
}
