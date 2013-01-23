package com.stephenwan.libutfood.model;


public enum FoodItemFlag
{
	ContainsBeef("LegendImages/beef.jpg"),
	ContainsEgg("LegendImages/eggs.jpg"),
	ContainsFishOrShellfish("LegendImages/fish.jpg"),
	GlutenFree("LegendImages/gluten.jpg"),
	HealthySuggestion("LegendImages/healthy.jpg	"),
	ContainsMilk("LegendImages/milk.jpg"),
	ContainsPeanutsOrTreeNuts("LegendImages/nuts.jpg"),
	ContainsPork("LegendImages/pork.jpg"),
	ContainsSoy("LegendImages/soy.jpg"),
	Vegan("LegendImages/vegan.jpg"),
	Vegetarian("LegendImages/veggie.jpg");
	
    FoodItemFlag(final String text) {
        this.text = text;
    }

    private final String text;
    
    public static FoodItemFlag getByValue(String text)
    {
    	for (FoodItemFlag flag : values())
    		if (flag.text.equals(text))
    			return flag;
    	return null;
    }
}