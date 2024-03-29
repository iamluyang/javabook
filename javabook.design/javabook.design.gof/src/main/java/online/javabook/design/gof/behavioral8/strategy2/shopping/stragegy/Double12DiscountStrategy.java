package online.javabook.design.gof.behavioral8.strategy2.shopping.stragegy;

import java.util.List;

public class Double12DiscountStrategy implements IDiscountStrategy {

    @Override
    public double discount(List<Double> prices) {
        double total = 0;
        for(double price : prices){
            total += price;
        }
        total = total * 0.8;
        return total;
    }
}
