package online.javabook.design.gof.structural6.flyweight.font.app.bad;

import online.javabook.design.gof.structural6.flyweight.font.Style;
import online.javabook.design.gof.structural6.flyweight.font.Font;

public class Main {
    public static void main(String[] args) {

        Font font1 = new Font("宋体", Style.BOLD, 12);
        Font font2 = new Font("宋体", Style.BOLD, 12);

        System.out.println("font1 == font2 ? " + (font1 == font2));
    }
}
