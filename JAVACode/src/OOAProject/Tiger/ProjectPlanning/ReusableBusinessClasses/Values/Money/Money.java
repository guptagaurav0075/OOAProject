package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Money implements Serializable{
    private int MajorAmount;
    private int MinorAmount;
    private Currency currencyType;
    
    
    public Money(int majorAmount, int minorAmount, Currency currencyType) {
		MajorAmount = majorAmount;
		MinorAmount = minorAmount;
		this.currencyType = currencyType;
	}
	public Money addMoney(Money other) {
       if(this.currencyType.equals(other.currencyType.getISOType())){
    	  Money mon = new Money(MajorAmount, MinorAmount, currencyType);
    	  mon.MajorAmount  = mon.MajorAmount+ other.MajorAmount;
    	  mon.MinorAmount = mon.MinorAmount+ other.MinorAmount;
    	  int offset = mon.MinorAmount/mon.currencyType.getRollOver();
    	  mon.MajorAmount =mon.MajorAmount + offset;
    	  mon.MinorAmount = mon.MinorAmount % mon.currencyType.getRollOver();
    	  return mon;
       }
        return null;
    }
    public Money subMoney(Money other) {
    	if(this.currencyType.equals(other.currencyType.getISOType())){
    		if(this.MajorAmount>other.MajorAmount){
    			Money mon = new Money(MajorAmount, MinorAmount, currencyType);
    			mon.MajorAmount  = mon.MajorAmount - other.MajorAmount;
    			mon.MinorAmount = mon.MinorAmount - other.MinorAmount;
    			if(mon.MinorAmount<0){
    				mon.MinorAmount=mon.currencyType.getRollOver() - mon.MinorAmount;
    			}
    			mon.MajorAmount =mon.MajorAmount -1;
      		  return mon;
    		}
    		if(this.MajorAmount<other.MajorAmount){
    		  Money mon = new Money(other.MajorAmount, other.MinorAmount, other.currencyType);
    		  mon.MajorAmount  = mon.MajorAmount - MajorAmount;
    		  mon.MinorAmount = mon.MinorAmount - MinorAmount;
    		  if(mon.MinorAmount<0){
    			 mon.MinorAmount=mon.currencyType.getRollOver() - mon.MinorAmount;
    		  }
    		  mon.MajorAmount =mon.MajorAmount -1;
    		  return mon;
    		}
    	}
          return null;
    }
    public int majorToMinor() {
    	
    	return MinorAmount + (MajorAmount * this.currencyType.getRollOver());
  
    }
    public Money minorToMajor() {
        int offset;
        Money mon = new Money(MajorAmount,MinorAmount, currencyType );
        offset = mon.MinorAmount/ mon.currencyType.getRollOver();
        mon.MajorAmount = mon.MajorAmount + offset;
        mon.MinorAmount = mon.MinorAmount % mon.currencyType.getRollOver();
        return mon;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MajorAmount;
		result = prime * result + MinorAmount;
		result = prime * result + ((currencyType == null) ? 0 : currencyType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (MajorAmount != other.MajorAmount)
			return false;
		if (MinorAmount != other.MinorAmount)
			return false;
		if (currencyType == null) {
			if (other.currencyType != null)
				return false;
		} else if (!currencyType.equals(other.currencyType))
			return false;
		return true;
	}
    
}