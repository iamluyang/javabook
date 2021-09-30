package online.javabook.design.gof.behavioral8.strategy2.shopping.app;

import online.javabook.design.gof.behavioral8.strategy2.shopping.stragegy.Double11DiscountStrategy;
import online.javabook.design.gof.behavioral8.strategy2.shopping.stragegy.Double12DiscountStrategy;
import online.javabook.design.gof.behavioral8.strategy2.shopping.stragegy.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(100);
        shoppingCart.add(200);
        shoppingCart.add(300);

        shoppingCart.setDiscountStrategy(new Double11DiscountStrategy());
        double total1 = shoppingCart.getTotalPrice();
        System.out.println(total1);

        shoppingCart.setDiscountStrategy(new Double12DiscountStrategy());
        double total2 = shoppingCart.getTotalPrice();
        System.out.println(total2);
    }
}
