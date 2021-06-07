package online.javabook.gof.behavioral.patterns5.memento1.browser.context;

import online.javabook.gof.behavioral.patterns5.memento1.browser.memento.History;
import online.javabook.gof.behavioral.patterns5.memento1.browser.memento.Memento;

public class Browser {

    private History history = new History();

    private String url;

    public void go(String url) {
        this.url = url;
        history.add(new Memento(url));
        System.out.println("->" + url);
    }

    public void back() {
        Memento memento = history.getUndo();
        this.url = memento.getState();
        System.out.println("<-" + url);
    }

    public void forward() {
        Memento memento = history.getRedo();
        this.url = memento.getState();
        System.out.println("->" + url);
    }

}
