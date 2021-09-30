package online.javabook.design.gof.behavioral1.chain;

public abstract class IChainHandler {

    private IChainHandler next;

    public void setNext(IChainHandler next) {
        this.next = next;
    }

    public abstract void handle(String request);

    public void nextHandler(String request) {
        if(next != null) {
            next.handle(request);
        }
    }
}
