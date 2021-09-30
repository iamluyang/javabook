package online.javabook.design.gof.structural6.flyweight.font;

import java.util.Objects;

public class Font {

    final String name;
    final int style;
    final int size;

    public Font(String name, int style, int size) {
        this.name = name;
        this.style = style;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Font font = (Font) o;
        return style == font.style &&
                size == font.size &&
                Objects.equals(name, font.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, style, size);
    }
}
