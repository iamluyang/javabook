package org.gof.behavioral.patterns1.chain;

public class CharacterFilter extends Filter {

    public void handle(char c) {
        if(Character.isLetter(c)) {
            System.out.println("Character has been handled");
        }
        doNext(c);
    }
}