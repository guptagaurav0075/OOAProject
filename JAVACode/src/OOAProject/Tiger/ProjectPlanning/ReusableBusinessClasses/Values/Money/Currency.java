package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money;

import java.util.*;

/**
 * 
 */
public class Currency {
	
	
    private String ISOType;
   
    private String majorCurrency;
    public String minorCurrency;
    public int rollOver;
	public Currency(String iSOType, String majorCurrency, String minorCurrency, int rollOver) {
		ISOType = iSOType;
		this.majorCurrency = majorCurrency;
		this.minorCurrency = minorCurrency;
		this.rollOver = rollOver;
	}
	public String getISOType() {
		return ISOType;
	}
	public String getMajorCurrency() {
		return majorCurrency;
	}
	public String getMinorCurrency() {
		return minorCurrency;
	}
	public int getRollOver() {
		return rollOver;
	}
    
}