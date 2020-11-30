package org.gof.structural.patterns6.flyweight.font;

public class Font {

    final String name;
    final int style;
    final int size;

    public Font(String name, int style, int size) {
        this.name = name;
        this.style = style;
        this.size = size;
    }
}
