package online.javabook.gof.behavioral.patterns1.chain.app;

import online.javabook.gof.behavioral.patterns1.chain.ChainHandler1;
import online.javabook.gof.behavioral.patterns1.chain.ChainHandler2;
import online.javabook.gof.behavioral.patterns1.chain.ChainHandler3;
import online.javabook.gof.behavioral.patterns1.chain.IChainHandler;

public class Main {
    public static void main(String[] args) {
        IChainHandler chainHandler1 = new ChainHandler1();
        IChainHandler chainHandler2 = new ChainHandler2();
        IChainHandler chainHandler3 = new ChainHandler3();

        chainHandler1.setNext(chainHandler2);
        chainHandler2.setNext(chainHandler3);

        chainHandler1.handle("request");
    }
}
