package org.gof.behavioral.patterns8.strategy2.shopping.stragegy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Double> prices = new ArrayList();

    private IDiscountStrategy discountStrategy;

    public IDiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(IDiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void add(double price) {
        prices.add(price);
    }

    public double getTotalPrice() {
        return discountStrategy.discount(prices);
    }
}
