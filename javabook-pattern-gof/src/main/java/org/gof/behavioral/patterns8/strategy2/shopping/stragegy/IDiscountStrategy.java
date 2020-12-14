package org.gof.behavioral.patterns8.strategy2.shopping.stragegy;

import java.util.List;

public interface IDiscountStrategy {

    double discount(List<Double> prices);
}
