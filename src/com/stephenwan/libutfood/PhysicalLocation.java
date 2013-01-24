package com.stephenwan.libutfood;

public enum PhysicalLocation {
	
	JesterCityLimits("01", "JCL"),
	JesterCityMarket("05", "Jester City Market"),
	Jester2ndFloorDining("12", "J2"),
	KinsolvingDiningHall("03", "Kinsolving Dining"),
	KinsMarket("14", "Kin's Mart"),
	CypressBend("08", "Cypress Bend"),
	LittlefieldPatioCafe("19", "Littlefield Cafe"),
	JestAPizza("26", "Jest A' Pizza");
	
    PhysicalLocation(final String text, final String readname) {
        this.text = text;
        this.readname = readname;
    }

    private final String text;
    private final String readname;
    
    public static PhysicalLocation getByValue(String text)
    {
    	for (PhysicalLocation flag : values())
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
