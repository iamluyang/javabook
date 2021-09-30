package online.javabook.design.gof.behavioral8.strategy2.shopping.stragegy;

import java.util.List;

public interface IDiscountStrategy {

    double discount(List<Double> prices);
}
