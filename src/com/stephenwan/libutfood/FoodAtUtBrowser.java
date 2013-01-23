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

public class FoodAtUtBrowser {

	public static FoodLocation[] getAllLocations()
	{
		ArrayList<FoodLocation> locs = new ArrayList<FoodLocation>();
		for (FoodLocations loc : FoodLocations.values())
			locs.add(getFoodAt(loc));
		return locs.toArray(new FoodLocation[locs.size()]);
			
	}
	
	public static FoodLocation getFoodAt(FoodLocations Location)
	{
		String baseURL = "http://129.116.62.55";
		Document doc = null;
		try
		{
			doc = Jsoup.connect(baseURL + "/foodpro/menuSamp.asp?locationNum=" + Location.toValue()).get();
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
		
		
		// get sub tables
		for (Element courseTable : mTable.select("> tbody > tr > td > table"))
		{
			// pull meal (course) name
			Element courseName = courseTable.getElementsByClass("menusampmeals").get(0);
			
			// get raw data (lines and items) from this meal
			Element rawData = courseTable.select("> tbody").get(0);
			rawData = rawData.getElementsByAttributeValue("height", "5").get(0);
			Elements rows = rawData.select("> td > table > tbody > tr");
			
			// traverse data
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
					
					tmpLineName = trycat.text();
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
						// this is a food item
						Element itemName = tryitem.get(0).select("> span > a").get(0);
						tmpFlags.clear();
						
						Elements flags = tryitem.get(0).parent().siblingElements();
						for (Element flagtd : flags)
						{
							// get flag and its enum type
							Element flagimg = flagtd.getElementsByTag("img").get(0);
							FoodItemFlag f = FoodItemFlag.getByValue(flagimg.attr("src").split("\\.")[0]);
							if (f != null)
								tmpFlags.add(f);
						}
						tmpItems.add(new FoodItem(itemName.text(), tmpFlags.toArray(new FoodItemFlag[tmpFlags.size()])));
						
						
					}
				}
				
				
			}
			
			FoodCourse course = new FoodCourse(courseName.text(), tmpLines.toArray(new FoodLine[tmpLines.size()]));
			tmpCourses.add(course);
			
		}
		
		FoodLocation location = new FoodLocation(Location.toString(), tmpCourses.toArray(new FoodCourse[tmpCourses.size()]));
		
		return location;
	}

}
