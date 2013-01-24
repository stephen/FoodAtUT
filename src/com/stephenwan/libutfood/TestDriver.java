/**
 * 
 */
package com.stephenwan.libutfood;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.stephenwan.libutfood.model.FoodCourse;
import com.stephenwan.libutfood.model.FoodItem;
import com.stephenwan.libutfood.model.FoodItemFlag;
import com.stephenwan.libutfood.model.FoodLine;
import com.stephenwan.libutfood.model.FoodLocation;

public class TestDriver {

	public static void main(String[] args) throws IOException {

		FoodLocation location = FoodAtUtBrowser.getFoodAt(PhysicalLocation.KinsolvingDiningHall);
		System.out.println("Location Name: " + location.getName());

		HashMap<String, FoodCourse> courses = location.getCourses();
		
		System.out.println("Courses Available: " + courses.keySet().toString());
		
		FoodCourse breakfast = courses.get("Breakfast");
		
		HashMap<String, FoodLine> lines = breakfast.getLines();
		
		System.out.println("Lines Available for Breakfast: " + lines.keySet().toString());
		
		System.out.println(courses.get("Breakfast").getLines().keySet());
		System.out.println(courses.get("Breakfast").getLines().get("Beverages").getItems().keySet());
		System.out.println(courses.get("Breakfast").getLines().get("Chef's Features").getItems().keySet());
		System.out.println(courses.get("Breakfast").getLines().keySet());
		

	}

}
