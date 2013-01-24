package com.stephenwan.libutfood.model;

import java.util.HashMap;

public class FoodLine {
	
	public FoodLine(String name, FoodItem[] items)
	{
		this.name = name;
		this.items = new HashMap<String, FoodItem>();
		for (FoodItem i : items)
			this.items.put(i.getName(), i);
	}

	String name;
	HashMap<String, FoodItem> items;
	
	public String getName()
	{
		return name;
	}
	public HashMap<String, FoodItem> getItems()
	{
		return items;
	}
	
	@Override
	public String toString() {
		String tmp = "  `-" + getName() + "\n";
		for (FoodItem item : items.values())
			tmp += "    `-" + item.toString() + "\n";
		return tmp;
	}
}
