package online.javabook.gof.structural.patterns6.flyweight.font.app.bad;

import online.javabook.gof.structural.patterns6.flyweight.font.Font;
import online.javabook.gof.structural.patterns6.flyweight.font.Style;

public class Main {
    public static void main(String[] args) {

        Font font1 = new Font("宋体", Style.BOLD, 12);
        Font font2 = new Font("宋体", Style.BOLD, 12);

        System.out.println("font1 == font2 ? " + (font1 == font2));
    }
}
