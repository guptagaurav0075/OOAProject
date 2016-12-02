package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money;

import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class Money implements Serializable, Comparable<Money>{

	private int majorAmount;
	private int minorAmount;
	private Currency currency;

	public Money(int majorAmount, int minorAmount, Currency currency) {
		this.majorAmount = majorAmount;
		this.minorAmount = minorAmount;
		this.currency = currency;
	}

	public Money add(Money other){

		if(!currency.equals(other.getCurrency())){
			return null;
		}

		int major = majorAmount + other.getMajorAmount();
		int minor = minorAmount + other.getMinorAmount();

		if(minor >= currency.getRollOverVal()){
			major += minor / currency.getRollOverVal();
			minor = minor % currency.getRollOverVal();
		}

		Money newVal = new Money(major, minor, currency);

		return newVal;
	}

	public Money difference(Money other){

		if(!currency.equals(other.getCurrency())){
			return null;
		}

		int myMajor = majorAmount;
		int myMinor = minorAmount;

		if(myMajor < other.getMajorAmount()){

			int newMinor = other.getMinorAmount();
			int newMajor = other.getMajorAmount();

			if(newMinor < myMinor){
				newMinor += other.getCurrency().getRollOverVal();
				newMajor -= 1;
			}

			int major = newMajor - myMajor;
			int minor = newMinor - myMinor;

			Money newVal = new Money(major, minor, currency);
			return newVal;
		} else {

			if(myMinor < other.getMinorAmount()){
				myMinor += currency.getRollOverVal();
				myMajor -= 1;
			}

			int major = myMajor - other.getMajorAmount();
			int minor = myMinor - other.getMinorAmount();

			Money newVal = new Money(major, minor, currency);

			return newVal;
		}
	}

	public Money div(int constant){

		double major = majorAmount;
		double minor = minorAmount;

		major = major / constant;
		minor = minor / constant;

		double majorDecimal = major - Math.floor(major);
		double minorExtra = majorDecimal * currency.getRollOverVal();

		minor += minorExtra;

		int majorVal = (int) floor(major);
		int minorVal = (int) floor(minor);

		if(minor > currency.getRollOverVal()){
			majorVal += (int) minor / currency.getRollOverVal();
			minorVal = (int) minor % currency.getRollOverVal();
		}

		Money newVal = new Money(majorVal, minorVal, currency);

		return newVal;
	}

	public Money multiply(int constant){

		int newMajor = majorAmount * constant;
		int newMinor = minorAmount * constant;

		if(newMinor > currency.getRollOverVal()){
			newMajor += newMinor / currency.getRollOverVal();
			newMinor = newMinor % currency.getRollOverVal();
		}

		Money newVal = new Money(newMajor, newMinor, currency);

		return newVal;
	}


	public Money minorToMajor() {
		int offset;

		Money money = new Money(majorAmount,minorAmount, currency);

		offset = money.minorAmount/ money.currency.getRollOverVal();
		money.majorAmount = money.majorAmount + offset;
		money.minorAmount = money.minorAmount % money.currency.getRollOverVal();

		return money;
	}

	public int majorToMinor() {
		int minorTotal = minorAmount + (majorAmount * this.currency.getRollOverVal());
		return minorTotal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Money money = (Money) o;

		if (majorAmount != money.majorAmount) return false;
		if (minorAmount != money.minorAmount) return false;
		return currency.equals(money.currency);

	}

	@Override
	public int hashCode() {
		int result = majorAmount;
		result = 31 * result + minorAmount;
		result = 31 * result + currency.hashCode();
		return result;
	}


	public int getMajorAmount() {
		return majorAmount;
	}

	public void setMajorAmount(int majorAmount) {
		this.majorAmount = majorAmount;
	}

	public int getMinorAmount() {
		return minorAmount;
	}

	public void setMinorAmount(int minorAmount) {
		this.minorAmount = minorAmount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public int compareTo(Money other) {

		if(!currency.equals(other.getCurrency())){
			return Integer.MIN_VALUE;
		}

		if (majorAmount > other.getMajorAmount()){
			return 1;
		}
		else if (majorAmount == other.getMajorAmount()){
			if (minorAmount > other.getMinorAmount())
				return 1;
			else if(minorAmount == other.getMinorAmount()){
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}

	}

	@Override
	public String toString(){
		return Integer.toString(majorAmount) + " " + currency.getMajorName() + " " + Integer.toString(minorAmount) + " " + currency.getMinorName();
	}
}