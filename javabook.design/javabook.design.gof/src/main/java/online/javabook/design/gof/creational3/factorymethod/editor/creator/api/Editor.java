package online.javabook.design.gof.creational3.factorymethod.editor.creator.api;

import online.javabook.design.gof.creational3.factorymethod.editor.product.api.Document;

import java.util.ArrayList;
import java.util.List;

public abstract class Editor {

    private String title;

    private Document current;

    private List<Document> documents = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void open(String file) {
        setTitle(file);
        current = createDocument(file);
        current.open();
        current.display();

        // multi-documents
        documents.add(current);
    }

    public void save() {
        current.save();
    }

    public void close() {
        current.close();
    }

    public void saveAll() {
        for (Document document : documents) {
            document.save();
        }
    }

    public void closeAll() {
        for (Document document : documents) {
            document.close();
        }
    }

    // Factory method
    protected abstract Document createDocument(String file);
}