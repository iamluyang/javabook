package online.javabook.pattern.gof.behavioral.patterns1.chain;

public class SymbolFilter extends Filter  {

    public void handle(char c) {
        System.out.println("Symbol has been handled");
        doNext(c);
    }
}