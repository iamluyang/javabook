package online.javabook.gof.behavioral.patterns3.iterator.characters.app;

import online.javabook.gof.behavioral.patterns3.iterator.characters.StringIterable;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        StringIterable iterable = new StringIterable("abcdef");

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
