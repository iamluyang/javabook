package org.gof.structural.patterns6.flyweight.font;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

    private static Map<String, Font> flyweights = new HashMap<String, Font>();

    public static Font create(String name, int style, int size) {
        Font font = new Font(name, style, size);

        if(!flyweights.containsKey(font.name)) {
            flyweights.put(font.name, font);
        }
        return flyweights.get(font.name);
    }
}
