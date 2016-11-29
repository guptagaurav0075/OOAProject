package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.CreditCard;

import java.io.Serializable;
import java.util.*;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Refrences.Person;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
/**
 * 
 */
public class CreditCard implements Serializable{
  
	private String CardNumber;

    private int securityCode;
    private Person billing_info;
    private Card_Network CardNetwork;
    private DateTime expiryMonthYear;
    
    public CreditCard(String cardNumber, int securityCode, Person billing_info, Card_Network cardNetwork,
		int month, int year)throws InvalidInput {
    	Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);
		int currentMonth = c.get(Calendar.MONTH);
		
    	if(String.valueOf(securityCode).length()>3||String.valueOf(securityCode).length()<1){
    		throw new InvalidInput("The security Code is not valid");
    	}
    	if(cardNetwork!=Card_Network.Discover || cardNetwork != Card_Network.VISA || cardNetwork != Card_Network.American_Express || cardNetwork != Card_Network.Master_Card){
    		throw new InvalidInput("Not a valid Card Network");
    	}
    	if(cardNumber.length()>19 || cardNumber.length()<15){
    		throw new InvalidInput("Card number is invalid");
    	}
    	if((currentYear>year) || (currentYear ==year && currentMonth>month)){
    		throw new InvalidInput("The Card has Expired ");    		
    	}
    	
    	
		CardNumber = cardNumber;
		this.securityCode = securityCode;
		this.billing_info = billing_info;
		CardNetwork = cardNetwork;
		this.expiryMonthYear = new DateTime(month, year);		
	}

	public CreditCard(String cardNumber, int securityCode, Person billing_info, Card_Network cardNetwork,
		DateTime expiryMonthYear) throws InvalidInput {
		Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);
		int currentMonth = c.get(Calendar.MONTH);
		
    	if(String.valueOf(securityCode).length()>3||String.valueOf(securityCode).length()<1){
    		throw new InvalidInput("The security Code is not valid");
    	}
    	if(cardNetwork!=Card_Network.Discover || cardNetwork != Card_Network.VISA || cardNetwork != Card_Network.American_Express || cardNetwork != Card_Network.Master_Card){
    		throw new InvalidInput("Not a valid Card Network");
    	}
    	if(cardNumber.length()>19 || cardNumber.length()<15){
    		throw new InvalidInput("Card number is invalid");
    	}
    	if((currentYear>expiryMonthYear.getYear()) || (currentYear ==expiryMonthYear.getYear() && currentMonth>expiryMonthYear.getMonth())){
    		throw new InvalidInput("The Card has Expired ");    		
    	}
		CardNumber = cardNumber;
		this.securityCode = securityCode;
		this.billing_info = billing_info;
		CardNetwork = cardNetwork;
		this.expiryMonthYear = expiryMonthYear;
	}

	@Override
	public String toString() {
		return "CreditCard [CardNumber=" + CardNumber + ", securityCode=" + securityCode + ", billing_info="
				+ billing_info + ", CardNetwork=" + CardNetwork + ", expiryMonthYear=" + expiryMonthYear + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CardNetwork == null) ? 0 : CardNetwork.hashCode());
		result = prime * result + ((CardNumber == null) ? 0 : CardNumber.hashCode());
		result = prime * result + ((billing_info == null) ? 0 : billing_info.hashCode());
		result = prime * result + ((expiryMonthYear == null) ? 0 : expiryMonthYear.hashCode());
		result = prime * result + securityCode;
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
		CreditCard other = (CreditCard) obj;
		if (CardNetwork != other.CardNetwork)
			return false;
		if (CardNumber == null) {
			if (other.CardNumber != null)
				return false;
		} else if (!CardNumber.equals(other.CardNumber))
			return false;
		if (billing_info == null) {
			if (other.billing_info != null)
				return false;
		} else if (!billing_info.equals(other.billing_info))
			return false;
		if (expiryMonthYear == null) {
			if (other.expiryMonthYear != null)
				return false;
		} else if (!expiryMonthYear.equals(other.expiryMonthYear))
			return false;
		if (securityCode != other.securityCode)
			return false;
		return true;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public Person getBilling_info() {
		return billing_info;
	}

	public Card_Network getCardNetwork() {
		return CardNetwork;
	}

	public DateTime getExpiryMonthYear() {
		return expiryMonthYear;
	}
	 
	

}