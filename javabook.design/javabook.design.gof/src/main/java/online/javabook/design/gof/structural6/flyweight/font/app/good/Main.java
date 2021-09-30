package online.javabook.design.gof.structural6.flyweight.font.app.good;

import online.javabook.design.gof.structural6.flyweight.font.Font;
import online.javabook.design.gof.structural6.flyweight.font.FontFlyweight;
import online.javabook.design.gof.structural6.flyweight.font.Style;

public class Main {
    public static void main(String[] args) {

        Font font1 = FontFlyweight.create("宋体", Style.BOLD, 12);
        Font font2 = FontFlyweight.create("宋体", Style.BOLD, 12);

        System.out.println("font1 == font2 ? " + (font1 == font2));
    }
}
