package com.stephenwan.libutfood.model;

import java.util.Arrays;

public class FoodItem {
	
	public FoodItem(String Name, FoodItemFlag[] Flags)
	{
		this.Name = Name;
		this.Flags = Flags;
	}

	String Name;
	FoodItemFlag[] Flags;
	
	public String getName()
	{
		return Name;
	}
	
	public FoodItemFlag[] getFlags()
	{
		return Flags;
	}

	
	@Override
	public String toString() {
		return Name + " (Flag: " + Arrays.toString(Flags) + ")";
	}
	
}
