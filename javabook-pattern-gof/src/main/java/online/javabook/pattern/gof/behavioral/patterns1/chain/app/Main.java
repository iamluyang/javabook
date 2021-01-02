package online.javabook.pattern.gof.behavioral.patterns1.chain.app;

import online.javabook.pattern.gof.behavioral.patterns1.chain.CharacterFilter;
import online.javabook.pattern.gof.behavioral.patterns1.chain.DigitFilter;
import online.javabook.pattern.gof.behavioral.patterns1.chain.Filter;
import online.javabook.pattern.gof.behavioral.patterns1.chain.SymbolFilter;

public class Main {
    public static void main(String[] args) {
        Filter firstFilter    = new SymbolFilter();
        CharacterFilter secondFilter = new CharacterFilter();
        DigitFilter thirdFilter     = new DigitFilter();

        firstFilter.setNext(secondFilter);
        secondFilter.setNext(thirdFilter);

        firstFilter.handle('A');
        firstFilter.handle('1');
    }
}
