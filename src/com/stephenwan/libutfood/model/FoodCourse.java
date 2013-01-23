package com.stephenwan.libutfood.model;

public class FoodCourse {
	
	public FoodCourse(String Name, FoodLine[] Lines)
	{
		this.Name = Name;
		this.Lines = Lines;
		
	}

	String Name;
	FoodLine[] Lines;
	
	public String getName()
	{
		return Name;
	}
	
	public FoodLine[] getLines()
	{
		return Lines;
	}
	
	@Override
	public String toString() {
		String tmp = "`-" + getName() + "\n";
		for (FoodLine line : Lines)
			tmp += line.toString();
		return tmp;
	}
}
