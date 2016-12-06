package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money;

import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class Currency implements Serializable{

	private String majorName;
	private String minorName;
	private String isoCode;
	private int rollOverVal;

	public Currency(String majorName, String minorName, String isoCode, int rollOverVal) {
		this.majorName = majorName;
		this.minorName = minorName;
		this.isoCode = isoCode;
		this.rollOverVal = rollOverVal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Currency currency = (Currency) o;

		if (rollOverVal != currency.rollOverVal) return false;
		if (!majorName.equals(currency.majorName)) return false;
		if (!minorName.equals(currency.minorName)) return false;
		return isoCode.equals(currency.isoCode);

	}

	@Override
	public int hashCode() {
		int result = majorName.hashCode();
		result = 31 * result + minorName.hashCode();
		result = 31 * result + isoCode.hashCode();
		result = 31 * result + rollOverVal;
		return result;
	}

	@Override
	public String toString() {
		return "Currency [majorName=" + majorName + ", minorName=" + minorName + ", isoCode=" + isoCode
				+ ", rollOverVal=" + rollOverVal + "]";
	}

	public String getMajorName() {

		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMinorName() {
		return minorName;
	}

	public void setMinorName(String minorName) {
		this.minorName = minorName;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public int getRollOverVal() {
		return rollOverVal;
	}

	public void setRollOverVal(int rollOverVal) {
		this.rollOverVal = rollOverVal;
	}
}
