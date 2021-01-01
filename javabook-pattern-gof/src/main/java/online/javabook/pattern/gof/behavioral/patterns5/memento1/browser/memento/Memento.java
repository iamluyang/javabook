package online.javabook.pattern.gof.behavioral.patterns5.memento1.browser.memento;

public class Memento {

    private String url;

    public Memento(String url){
        this.url = url;
    }

    public String getState(){
        return url;
    }
}
