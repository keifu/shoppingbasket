package com.shoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * Implementation of @link ShoppingCartCalcculator}
 * Also stores prices of items in a map
 * 
 * @author Keith
 *
 */
public class ShoppingCartCalculatorImpl implements ShoppingCartCalculator {
	
	private Map<String, Integer> map = new HashMap<>();

	public ShoppingCartCalculatorImpl() {
		map.put(BANANA, 10);
		map.put(ORANGE, 20);
		map.put(APPLE, 30);
		map.put(LEMON, 40);
		map.put(PEACHE, 50);
	}
	
	@Override
	public int calculateCost(List<String> basket) {
			Objects.requireNonNull(basket);
			int totalCost =  basket.stream().mapToInt(map::get).sum();
			return totalCost;
	}

}
