package com.stephenwan.libutfood.model;

public class FoodLine {
	
	public FoodLine(String Name, FoodItem[] Items)
	{
		this.Name = Name;
		this.Items = Items;
	}

	String Name;
	FoodItem[] Items;
	
	public String getName()
	{
		return Name;
	}
	public FoodItem[] getItems()
	{
		return Items;
	}
	
	@Override
	public String toString() {
		String tmp = "  `-" + getName() + "\n";
		for (FoodItem item : Items)
			tmp += "    `-" + item.toString() + "\n";
		return tmp;
	}
}
