package com.stephenwan.libutfood.model;

public enum FoodLocations {
	
	JesterCityLimits("01", "JCL"),
	JesterCityMarket("05", "Jester City Market"),
	Jester2ndFloorDining("12", "J2"),
	KinsolvingDiningHall("03", "Kinsolving Dining"),
	KinsMarket("14", "Kin's Mart"),
	CypressBend("08", "Cypress Bend"),
	LittlefieldPatioCafe("19", "Littlefield Cafe"),
	JestAPizza("26", "Jest A' Pizza");
	
    FoodLocations(final String text, final String readname) {
        this.text = text;
        this.readname = readname;
    }

    private final String text;
    private final String readname;
    
    public static FoodLocations getByValue(String text)
    {
    	for (FoodLocations flag : values())
    		if (flag.text.equals(text))
    			return flag;
    	return null;
    }
    
    public String getReadName()
    {
    	return readname;
    }
    
    public String toValue() {
    	// TODO Auto-generated method stub
    	return text;
    }
}
