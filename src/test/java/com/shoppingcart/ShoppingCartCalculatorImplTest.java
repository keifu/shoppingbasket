package com.shoppingcart;

import static com.shoppingcart.ShoppingCartCalculator.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(JUnitParamsRunner.class)
public class ShoppingCartCalculatorImplTest {
	
	private ShoppingCartCalculator shoppingCartCalcculator;
	
	@Before
	public void setup() {
		shoppingCartCalcculator = new ShoppingCartCalculatorImpl();
	}
	
	@After
	public void tearDown(){
		shoppingCartCalcculator = null;
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateCost_Null(){
		shoppingCartCalcculator.calculateCost(null);
	}
	
	@Test
	public void testCalculateCost_Empty_Basket(){
		int totalCost = shoppingCartCalcculator.calculateCost(Collections.emptyList());
		assertEquals(0, totalCost);
	}
	
	public static Collection<Object[]> getItems() {
		return Arrays.asList(new Object[][] { 
				{BANANA, 10},
				{ORANGE, 20}, 
				{APPLE,  30},
				{LEMON,  40},
				{PEACHE, 50}
		});
	}
	
	@Test
	@Parameters(method = "getItems")
	public void testCalculateCost_One_Item(String item, int expectedCost){
		List<String> basket = new ArrayList<>();
		basket.add(item);
		
		int totalCost = shoppingCartCalcculator.calculateCost(basket);
		assertEquals(expectedCost, totalCost);
	}
	
	@Test
	public void testCalculateCost_Multiple_Items(){
		List<String> basket = new ArrayList<>();
		basket.add(BANANA);
		basket.add(ORANGE);
		basket.add(APPLE);
		basket.add(LEMON);
		basket.add(PEACHE);
		
		int totalCost = shoppingCartCalcculator.calculateCost(basket);
		assertEquals(150, totalCost);
	}
	
	@Test
	public void testCalculateCost_Duplicate_Items(){
		List<String> basket = new ArrayList<>();
		basket.add(BANANA);
		basket.add(BANANA);
		basket.add(APPLE);
		basket.add(APPLE);
		basket.add(PEACHE);
		
		int totalCost = shoppingCartCalcculator.calculateCost(basket);
		assertEquals(130, totalCost);
	}
	
}
