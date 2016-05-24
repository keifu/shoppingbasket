package com.shoppingcart;

import java.util.List;

/**
 *  Interface for calculating the cost of a shopping basket
 */
public interface ShoppingCartCalculator{
	
	public static final String BANANA = "Bananas";
	public static final String ORANGE = "Orange";
	public static final String APPLE = "Apple";
	public static final String LEMON = "Lemon";
	public static final String PEACHE = "Peach";
	
	public int calculateCost(List<String> basket);

}
