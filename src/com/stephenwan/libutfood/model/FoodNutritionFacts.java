package com.stephenwan.libutfood.model;

import java.util.HashMap;

public class FoodNutritionFacts {
	public FoodNutritionFacts(String name, float servingSize, String servingUnit, int calories, int caloriesFromFat, HashMap<String, FoodNutritionItem> items, String ingredients, String allergens)
	{
		this.name = name;
		this.servingSize = servingSize;
		this.servingUnit = this.servingUnit;
		this.calories = calories;
		this.calories = caloriesFromFat;
		this.items = items;
	}
	
	private String name;
	private float servingSize;
	private String servingUnit;
	private int calories;
	private int caloriesFromFat;
	private HashMap<String, FoodNutritionItem> items;
	
	private String ingredients;
	private String allergens;
	
	public static class FoodNutritionItem
	{
		public FoodNutritionItem(String name, float amount, String amountUnit, float dVPercentage)
		{
			this.name = name;
			this.amount = amount;
			this.amountUnit = amountUnit;
			this.dVPercentage = dVPercentage;
			
		}
		
		private String name;
		private float amount;
		private String amountUnit;
		private float dVPercentage;
	}
}
