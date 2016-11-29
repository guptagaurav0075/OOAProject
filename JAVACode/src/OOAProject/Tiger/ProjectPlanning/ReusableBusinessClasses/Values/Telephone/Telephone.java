package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Telephone;

import java.io.Serializable;
import java.util.*;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.*;

public class Telephone implements Serializable {

    private String cityCode;
    private String number;
    private String extension = "";
    private String countryCode = "1";
    private PhoneNumberType type;
	public Telephone(String cityCode, String number, String extension, String countryCode, PhoneNumberType type) throws InvalidInput {
		if(number.length()!=7){
			throw new InvalidInput("the number entered is invalid");
		}
		if(cityCode.length()<1 && cityCode.length()>5){
			throw new InvalidInput("The city code entered is invalid");
		}
		if(countryCode.length()>5){
			throw new InvalidInput("Input for country code is incorrect");
		}
		this.cityCode = cityCode;
		this.number = number;
		this.extension = extension;
		this.countryCode = countryCode;
		this.type = type;
	}
	public Telephone(String cityCode, String number, String extension, PhoneNumberType type) throws InvalidInput {
		
		if(number.length()!=7){
			throw new InvalidInput("the number entered is invalid");
		}
		if(cityCode.length()<1 && cityCode.length()>5){
			throw new InvalidInput("The city code entered is invalid");
		}
		
		this.cityCode = cityCode;
		this.number = number;
		this.extension = extension;
		this.type = type;
	}
	public Telephone(String cityCode, String number, PhoneNumberType type) throws InvalidInput {
		if(number.length()!=7){
			throw new InvalidInput("the number entered is invalid");
		}
		if(cityCode.length()<1 && cityCode.length()>5){
			throw new InvalidInput("The city code entered is invalid");
		}
		
		
		this.cityCode = cityCode;
		this.number = number;
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(extension ==""){
			result = prime * result + ((cityCode == null) ? 0 : cityCode.hashCode());
			result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
			result = prime * result + ((extension == null) ? 0 : extension.hashCode());
			result = prime * result + ((number == null) ? 0 : number.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}
		else{
			result = prime * result + ((cityCode == null) ? 0 : cityCode.hashCode());
			result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
			result = prime * result + ((extension == null) ? 0 : extension.hashCode());
			result = prime * result + ((number == null) ? 0 : number.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telephone other = (Telephone) obj;
		if (cityCode == null) {
			if (other.cityCode != null)
				return false;
		} else if (!cityCode.equals(other.cityCode))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if(extension=="")
			return "TelephoneNumber ["+countryCode + " -" + cityCode + "-" + number + "-" + "\n  type=" + type + "]";
		else{
			return "TelephoneNumber ["+countryCode + " -" + cityCode + "-" + number + "-" + extension +"\n  type=" + type + "]";
		}
	}    

}