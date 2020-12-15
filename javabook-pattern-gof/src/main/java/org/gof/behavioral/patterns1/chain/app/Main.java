package org.gof.behavioral.patterns1.chain.app;

import org.gof.behavioral.patterns1.chain.CharacterFilter;
import org.gof.behavioral.patterns1.chain.DigitFilter;
import org.gof.behavioral.patterns1.chain.Filter;
import org.gof.behavioral.patterns1.chain.SymbolFilter;

public class Main {
    public static void main(String[] args) {
        Filter          firstFilter    = new SymbolFilter();
        CharacterFilter secondFilter = new CharacterFilter();
        DigitFilter     thirdFilter     = new DigitFilter();

        firstFilter.setNext(secondFilter);
        secondFilter.setNext(thirdFilter);

        firstFilter.handle('A');
        firstFilter.handle('1');
    }
}
