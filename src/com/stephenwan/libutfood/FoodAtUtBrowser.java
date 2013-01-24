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

public class FoodAtUtBrowser {

	public static FoodLocation[] getAllLocations()
	{
		ArrayList<FoodLocation> locs = new ArrayList<FoodLocation>();
		for (PhysicalLocation loc : PhysicalLocation.values())
			locs.add(getFoodAt(loc));
		return locs.toArray(new FoodLocation[locs.size()]);
			
	}
	
	public static FoodLocation getFoodAt(PhysicalLocation location, boolean getNutrition)
	{
		return DataScraper.scrapeDataFor(location, getNutrition);
	}
	
	public static FoodLocation getFoodAt(PhysicalLocation location)
	{
		return getFoodAt(location, true);
	}

}
