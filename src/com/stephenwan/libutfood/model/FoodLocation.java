package com.stephenwan.libutfood.model;

import java.util.HashMap;

public class FoodLocation {

	public FoodLocation(String name, FoodCourse[] courses)
	{
		this.name = name;
		this.courses = new HashMap<String, FoodCourse>();
		for (FoodCourse f : courses)
			this.courses.put(f.getName(), f);
	}
	
	String name;
	HashMap<String, FoodCourse> courses;
	
	public String getName()
	{
		return name;
	}
	
	public HashMap<String, FoodCourse> getCourses()
	{
		return courses;
	}
	
	@Override
	public String toString() {
		String tmp = getName() + "\n";
		for (FoodCourse course : courses.values())
			tmp += course.toString();
		return tmp;
	}

}
