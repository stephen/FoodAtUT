package com.stephenwan.libutfood;

import java.io.IOException;
import java.util.ArrayList;
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
import com.stephenwan.libutfood.model.FoodNutritionFacts;

class DataScraper {

	static FoodLocation scrapeDataFor(PhysicalLocation location, boolean getNutrition)
	{
		String baseURL = "http://129.116.62.55/foodpro/";
		Document doc = null;
		try
		{
			doc = Jsoup.connect(baseURL + "menuSamp.asp?locationNum=" + location.toValue()).get();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		
		// tmp
		ArrayList<FoodItem> tmpItems = new ArrayList<FoodItem>();
		ArrayList<FoodLine> tmpLines = new ArrayList<FoodLine>();
		ArrayList<FoodCourse> tmpCourses = new ArrayList<FoodCourse>();
		ArrayList<FoodItemFlag> tmpFlags = new ArrayList<FoodItemFlag>();
		String tmpLineName = null;
		
		// main table
		Elements mtry = doc.getElementsByAttributeValue("bordercolorlight", "black");
		if (mtry.size() == 0)
			return null;
		
		Element mTable = mtry.get(0);
		
		
		// get sub tables (meals -> breakfast, lunch, dinner)
		for (Element courseTable : mTable.select("> tbody > tr > td > table"))
		{
			// pull meal (course) name
			Element courseName = courseTable.getElementsByClass("menusampmeals").get(0);
			
			
			// get nutrition data
			// if requested in query
			
			// nutrition link
			Element nutritionLink = courseName.parent().parent().getElementsByAttributeValue("name", courseName.text()).get(0);
			
			// nutrition data holder
			HashMap<String, String> nutritionMap = null;
			
			if (getNutrition) // only pull nutrition data if required
			{
				try
				{
					Document nutritionDoc = Jsoup.connect(baseURL + nutritionLink.attr("href")).get();
					nutritionMap = new HashMap<String, String>(); // init mapping
					
					// pull data to be inserted into fooditem objects later
					Elements nutritionData = nutritionDoc.getElementsByClass("pickmenucoldispname"); // pick menu column display name...
					
					// go through all of these divs with class
					for (Element e : nutritionData)
					{
						Elements atry = e.getElementsByTag("a"); // try to pull the <a> tag with required data
						if (atry.size() == 1)
							nutritionMap.put(atry.get(0).text(), baseURL + atry.get(0).attr("href"));
							
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
					return null;
				}
			}
			
			
			// get raw data (lines and items) from this meal
			Element rawData = courseTable.select("> tbody").get(0);
			rawData = rawData.getElementsByAttributeValue("height", "5").get(0);
			Elements rows = rawData.select("> td > table > tbody > tr");
			
			// traverse data for this 
			for (Element tr : rows)
			{
				// try to get cat? new cat if this is true 
				Elements trycat = tr.getElementsByClass("menusampcats");
				if (trycat.size() == 1)
				{
					// a category exists, we need to make a new one
					if (tmpLineName != null)
					{
						FoodLine fl = new FoodLine(tmpLineName, tmpItems.toArray(new FoodItem[tmpItems.size()]));
						tmpLines.add(fl);
					}
					
					tmpLineName = trycat.text().replaceAll("-- ", "").replaceAll(" --", "");
					tmpItems.clear();
				}
				else
				{
					// this tr is probably a food item
					Elements tryitem = tr.getElementsByClass("menusamprecipes");
					if (tryitem.size() == 0)
						continue; // this tr isn't a category (line), nor a recipe
					else
					{
						//
						// this is a food item
						//
						
						// get name
						Element itemName = tryitem.get(0).select("> span > a").get(0);
						tmpFlags.clear();
						
						// get nutrition flags
						Elements flags = tryitem.get(0).parent().siblingElements();
						for (Element flagtd : flags)
						{
							// get flag and its enum type
							Element flagimg = flagtd.getElementsByTag("img").get(0);
							FoodItemFlag f = FoodItemFlag.getByValue(flagimg.attr("src").split("\\.")[0]);
							if (f != null)
								tmpFlags.add(f);
						}
						// get nutrition data if available
						String link = null;
						if (nutritionMap != null && nutritionMap.containsKey(itemName.text()))
							link = nutritionMap.get(itemName.text());
						
						// done
						tmpItems.add(new FoodItem(itemName.text(), tmpFlags.toArray(new FoodItemFlag[tmpFlags.size()]), link));
						
					}
				}
			}
			
			// when this is done, we haven't saved the last line yet
			FoodLine fl = new FoodLine(tmpLineName, tmpItems.toArray(new FoodItem[tmpItems.size()]));
			tmpLines.add(fl);
			
			FoodCourse course = new FoodCourse(courseName.text(), tmpLines.toArray(new FoodLine[tmpLines.size()]));
			tmpCourses.add(course);
			
			tmpLines.clear();
			tmpLineName = null;
			
		}
		
		FoodLocation loc = new FoodLocation(location.toString(), tmpCourses.toArray(new FoodCourse[tmpCourses.size()]));
		
		return loc;
	}
	
	@Deprecated
	static FoodNutritionFacts getNutrition(String nutritionLink)
	{
		Document doc = null;
		try
		{ 
			doc = Jsoup.connect(nutritionLink).get();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		// get name of food item
		Elements foodNameTry = doc.getElementsByClass("labelrecipe");
		if (foodNameTry.size() == 0)
			throw new FoodAtUtException("Failed to get name for nutrition link: " + nutritionLink);
		String foodName = foodNameTry.get(0).text();
		
		
		// get other nutrition information
		Element ssPivot = doc.getElementsMatchingText("Serving Size").get(0).parent();
		
		
		// get ingredients (optional)
		Elements ingredTry = doc.getElementsByClass("labelingredientsvalue");
		String ingredientsList = null;
		if (ingredTry.size() == 0)
			 ingredientsList = ingredTry.text();

		// get allergens (optional)
		Elements allergensTry = doc.getElementsByClass("labelallergensvalue");
		String allergensList = null;
		if (allergensTry.size() == 0)
			 allergensList = allergensTry.text();
		
		
		
		return null;
			
			
		
	}

}
