package com.stephenwan.libutfood.model;

public enum FoodLocations {
	
	JesterCityLimits("01"),
	JesterCityMarket("05"),
	Jester2ndFloorDining("12"),
	KinsolvingDiningHall("03"),
	KinsMarket("14"),
	CypressBend("08"),
	LittlefieldPatioCafe("19"),
	JestAPizza("26");
	
    FoodLocations(final String text) {
        this.text = text;
        
    }

    private final String text;
    
    public static FoodLocations getByValue(String text)
    {
    	for (FoodLocations flag : values())
    		if (flag.text.equals(text))
    			return flag;
    	return null;
    }
    
    public String toValue() {
    	// TODO Auto-generated method stub
    	return text;
    }
}
