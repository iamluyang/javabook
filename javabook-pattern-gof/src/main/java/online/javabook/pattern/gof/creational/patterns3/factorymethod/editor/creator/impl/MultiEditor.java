package online.javabook.pattern.gof.creational.patterns3.factorymethod.editor.creator.impl;

import online.javabook.pattern.gof.creational.patterns3.factorymethod.editor.creator.api.Editor;
import online.javabook.pattern.gof.creational.patterns3.factorymethod.editor.product.api.Document;
import org.apache.commons.io.FilenameUtils;

import java.util.HashMap;
import java.util.Map;

public class MultiEditor extends Editor {

    private Map<String, Class<? extends Document>> registers = new HashMap<>();

    // register methods
    public <T extends Class<? extends Document>> void registerDocumentClass(String extension, T documentClass) {
        registers.put(extension, documentClass);
    }

    protected Class<? extends Document> getRegisteredDocumentClass(String extension) {
        Class<? extends Document> documentClass = registers.get(extension);
        return documentClass;
    }

    // Factory method
    protected Document createDocument(String fileName) {
        String extension = FilenameUtils.getExtension(fileName);
        Class<? extends Document> documentClass = getRegisteredDocumentClass(extension);

        Document document = null;
        try {
            document = documentClass.newInstance();
            document.setFile(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
}