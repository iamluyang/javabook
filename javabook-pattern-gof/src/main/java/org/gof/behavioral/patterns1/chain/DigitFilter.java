package org.gof.behavioral.patterns1.chain;

public class DigitFilter extends Filter {

    public void handle(char c) {
        if(Character.isDigit(c)) {
            System.out.println("Digit has been handled");
        }
        doNext(c);
    }
}