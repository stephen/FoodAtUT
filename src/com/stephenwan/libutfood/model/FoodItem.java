package com.stephenwan.libutfood.model;

import java.util.Arrays;

public class FoodItem {
	
	public FoodItem(String name, FoodItemFlag[] flags, String nutritionLink)
	{
		this.name = name;
		this.flags = flags;
		this.nutritionLink = nutritionLink;
	}

	String name;
	String nutritionLink;
	FoodItemFlag[] flags;
	
	public String getName()
	{
		return name;
	}
	
	public FoodItemFlag[] getFlags()
	{
		return flags;
	}
	
	public boolean containsFlag(FoodItemFlag flag)
	{
		for (FoodItemFlag f : flags)
			if (f.equals(flag))
				return true;
		return false;
	}
	
	public String getNutritionLink()
	{
		return nutritionLink;
	}

	
	@Override
	public String toString() {
		return name + " (Flag: " + Arrays.toString(flags) + ", " + nutritionLink + ")";
	}
	
}
