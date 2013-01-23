/**
 * 
 */
package com.stephenwan.libutfood;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.stephenwan.libutfood.model.FoodCourse;
import com.stephenwan.libutfood.model.FoodItem;
import com.stephenwan.libutfood.model.FoodItemFlag;
import com.stephenwan.libutfood.model.FoodLine;
import com.stephenwan.libutfood.model.FoodLocation;
import com.stephenwan.libutfood.model.FoodLocations;

public class TestDriver {

	public static void main(String[] args) throws IOException {
		
		for (FoodLocation loc : FoodAtUtBrowser.getAllLocations())
			System.out.println(loc.toString() + "\n");
		//System.out.println(FoodAtUtBrowser.getFoodAt(FoodLocations.KinsolvingDiningHall));
		
	}

}
