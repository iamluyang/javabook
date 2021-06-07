package online.javabook.gof.behavioral.patterns1.chain;

public class ChainHandler2 extends IChainHandler {

    @Override
    public void handle(String request) {
        System.out.println(this.getClass().getSimpleName() + ": handler " + request);

        nextHandler(request);
    }
}