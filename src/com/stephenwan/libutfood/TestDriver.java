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

		// get data for this location, true for nutrition links
		FoodLocation location = FoodAtUtBrowser.getFoodAt(PhysicalLocation.KinsolvingDiningHall, true);
		System.out.println("Location Name: " + location.getName());

		// pull courses available (breakfast, lunch, dinner?)
		HashMap<String, FoodCourse> courses = location.getCourses();
		System.out.println("Courses Available: " + courses.keySet().toString());
		
		// pull lines available in the Breakfast course
		FoodCourse breakfast = courses.get("Breakfast");
		HashMap<String, FoodLine> lines = breakfast.getLines();
		System.out.println("Lines Available for Breakfast: " + lines.keySet().toString());
		
		// pull items available in the Sweet Sensations line
		FoodLine sweet = lines.get("Sweet Sensations");
		HashMap<String, FoodItem> items = sweet.getItems();
		System.out.println("Items Available in Sweet Sensations: " + items.keySet().toString());
		
		FoodItem muffin = items.get("Oatbran Muffin");
		System.out.println("Information for Oatbran Muffin: " + muffin);
	}

}
