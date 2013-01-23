package com.stephenwan.libutfood.model;

public class FoodLocation {

	public FoodLocation(String Name, FoodCourse[] Courses)
	{
		this.Name = Name;
		this.Courses = Courses;
	}
	
	String Name;
	FoodCourse[] Courses;
	
	public String getName()
	{
		return Name;
	}
	
	public FoodCourse[] getCourses()
	{
		return Courses;
	}
	
	@Override
	public String toString() {
		String tmp = getName() + "\n";
		for (FoodCourse course : Courses)
			tmp += course.toString();
		return tmp;
	}

}
