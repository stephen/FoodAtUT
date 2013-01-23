package com.stephenwan.libutfood.model;


public enum FoodItemFlag
{
	ContainsBeef("LegendImages/beef"),
	ContainsEgg("LegendImages/eggs"),
	ContainsFishOrShellfish("LegendImages/fish"),
	GlutenFree("LegendImages/gluten"),
	HealthySuggestion("LegendImages/healthy"),
	ContainsMilk("LegendImages/milk"),
	ContainsPeanutsOrTreeNuts("LegendImages/nuts"),
	ContainsPork("LegendImages/pork"),
	ContainsSoy("LegendImages/soy"),
	Vegan("LegendImages/vegan"),
	Vegetarian("LegendImages/veggie");
	
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