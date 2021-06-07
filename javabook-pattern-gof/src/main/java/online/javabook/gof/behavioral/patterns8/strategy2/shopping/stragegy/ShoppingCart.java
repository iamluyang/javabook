package online.javabook.gof.behavioral.patterns8.strategy2.shopping.stragegy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private IDiscountStrategy discountStrategy;
	
	private List<Double> prices = new ArrayList<Double>();
	
	public void add(double items) {
		prices.add(items);
	}

	public IDiscountStrategy getDiscountStrategy() {
		return discountStrategy;
	}

	public void setDiscountStrategy(IDiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}
	
	public double getTotalPrice() {
		return this.discountStrategy.discount(prices);
	}
}
