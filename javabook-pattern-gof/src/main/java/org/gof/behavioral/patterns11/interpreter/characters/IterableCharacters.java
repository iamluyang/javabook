package org.gof.behavioral.patterns11.interpreter.characters;

import java.util.Iterator;

public class IterableCharacters implements Iterable<Character> {

    private String original;

    public IterableCharacters(String original) {
        this.original = original;
    }

    public Iterator<Character> iterator() {
        return new InnerIterator();
    }

    // InnerIterator
    private class InnerIterator implements Iterator<Character> {

        private int index;

        public boolean hasNext() {
            return index < original.length();
        }

        public Character next() {
            Character c = original.charAt(index);
            index++;
            return c;
        }

        public void remove() {}
    }
}