package org.gof.behavioral.patterns11.interpreter.characters.app;

import org.gof.behavioral.patterns11.interpreter.characters.IterableCharacters;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        IterableCharacters iterable = new IterableCharacters("abcdef");

        Iterator<Character> iterator = iterable.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("----------------------------------------");

        for(Character character : iterable) {
            System.out.println(character);
        }
    }
}
