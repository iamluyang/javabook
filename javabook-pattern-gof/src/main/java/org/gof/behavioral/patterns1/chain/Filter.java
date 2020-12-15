package org.gof.behavioral.patterns1.chain;

public abstract class Filter {

    private Filter next;

    public void setNext(Filter next) {
        this.next = next;
    }

    public void doNext(char c) {
        if(next != null) {
            next.handle(c);
        }
    }

    public abstract void handle(char c);
}
