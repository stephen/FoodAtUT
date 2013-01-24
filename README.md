FoodAtUT
========

Java Library for scraping UT Austin's foodpro data.

Usage
-----

```java
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
```

Output
------
```
Location Name: KinsolvingDiningHall
Courses Available: [Dinner, Breakfast, Lunch]
Lines Available for Breakfast: [Beverages, Sweet Sensations, Chef's Features]
Items Available in Sweet Sensations: [Oatbran Muffin, Glazed Doughnut, Belgian Waffles]
Information for Oatbran Muffin: Oatbran Muffin (Flag: [ContainsMilk, ContainsEgg, ContainsSoy, Vegetarian, HealthySuggestion], http://129.116.62.55/foodpro/label.asp?locationNum=03&locationName=&dtdate=01%2F23%2F2013&RecNumAndPort=213024%2A1)
```