package com.stephenwan.libutfood.model;

import java.util.HashMap;

public class FoodCourse {
	
	public FoodCourse(String name, FoodLine[] lines)
	{
		this.name = name;
		this.lines = new HashMap<String, FoodLine>();
		for (FoodLine l : lines)
			this.lines.put(l.getName(), l);
		
	}

	String name;
	HashMap<String, FoodLine> lines;
	
	public String getName()
	{
		return name;
	}
	
	public HashMap<String, FoodLine> getLines()
	{
		return lines;
	}
	
	@Override
	public String toString() {
		String tmp = "`-" + getName() + "\n";
		for (FoodLine line : lines.values())
			tmp += line.toString();
		return tmp;
	}
}
