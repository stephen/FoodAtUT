package com.stephenwan.libutfood.model;

import java.util.Arrays;

public class FoodItem {
	
	public FoodItem(String Name, FoodItemFlag[] Flags, String NutritionLink)
	{
		this.Name = Name;
		this.Flags = Flags;
		this.NutritionLink = NutritionLink;
	}

	String Name;
	String NutritionLink;
	FoodItemFlag[] Flags;
	
	public String getName()
	{
		return Name;
	}
	
	public FoodItemFlag[] getFlags()
	{
		return Flags;
	}
	
	public String getNutritionLink()
	{
		return NutritionLink;
	}

	
	@Override
	public String toString() {
		return Name + " (Flag: " + Arrays.toString(Flags) + ", " + getNutritionLink() + ")";
	}
	
}
