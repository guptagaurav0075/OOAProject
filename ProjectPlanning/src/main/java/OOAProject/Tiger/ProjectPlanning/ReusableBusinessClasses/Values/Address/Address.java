package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Address;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;;

public class Address {
    private String AptNumber;
    private String StreetAddress;
    private String City;
    private String Postal_Code;
    private String Country;
    private String StateOrProvince;
    private AddressType type = AddressType.HOME;//Default Value
	public Address(String aptNumber, String streetAddress, String city, String StateOrProvince, String Postal_Code, String country) throws InvalidInput {
		
		if(aptNumber.length()== 0){
			throw new InvalidInput("Apartment Number value is blank");
		}
		if(streetAddress.length() == 0){
			throw new InvalidInput("Street Address value is blank");
		}
		if(city.length()== 0){
			throw new InvalidInput("City value is blank");
		}
		if(Postal_Code.length()>14){
			throw new InvalidInput("Postal Code value is invalid");
		}
		if(country.length()==0){
			throw new InvalidInput("Country value is blank");
		}
		if(StateOrProvince.length()==0){
			throw new InvalidInput("State or Provice value is blank");
		}
		AptNumber = aptNumber;
		StreetAddress = streetAddress;
		City = city;
		this.Postal_Code = Postal_Code;
		Country = country;
		this.StateOrProvince = StateOrProvince;
	}
	public Address(String aptNumber, String streetAddress, String city, String StateOrProvince, String country,
			AddressType type) throws InvalidInput{
		
		if(aptNumber.length()== 0){
			throw new InvalidInput("Apartment Number value is blank");
		}
		if(streetAddress.length() == 0){
			throw new InvalidInput("Street Address value is blank");
		}
		if(city.length()== 0){
			throw new InvalidInput("City value is blank");
		}		
		if(country.length()==0){
			throw new InvalidInput("Country value is blank");
		}
		if(StateOrProvince.length()==0){
			throw new InvalidInput("State or Provice value is blank");
		}
		AptNumber = aptNumber;
		StreetAddress = streetAddress;
		City = city;
		this.Postal_Code = Postal_Code;
		this.StateOrProvince = StateOrProvince;
		Country = country;
		this.type = type;
	}
	public String getAptNumber() {
		return AptNumber;
	}
	public String getStreetAddress() {
		return StreetAddress;
	}
	public String getCity() {
		return City;
	}
	public String getPostal_Code() {
		return Postal_Code;
	}
	public String getCountry() {
		return Country;
	}
	public String getStateOrProvince() {
		return StateOrProvince;
	}
	public AddressType getType() {
		return type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(Postal_Code.length()!=0){
			result = prime * result + ((AptNumber == null) ? 0 : AptNumber.hashCode());
			result = prime * result + ((City == null) ? 0 : City.hashCode());
			result = prime * result + ((Country == null) ? 0 : Country.hashCode());
			result = prime * result + ((Postal_Code == null) ? 0 : Postal_Code.hashCode());
			result = prime * result + ((StateOrProvince == null) ? 0 : StateOrProvince.hashCode());
			result = prime * result + ((StreetAddress == null) ? 0 : StreetAddress.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}
		else{
			result = prime * result + ((AptNumber == null) ? 0 : AptNumber.hashCode());
			result = prime * result + ((City == null) ? 0 : City.hashCode());
			result = prime * result + ((Country == null) ? 0 : Country.hashCode());
			result = prime * result + ((StateOrProvince == null) ? 0 : StateOrProvince.hashCode());
			result = prime * result + ((StreetAddress == null) ? 0 : StreetAddress.hashCode());
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
		Address other = (Address) obj;
		if (AptNumber == null) {
			if (other.AptNumber != null)
				return false;
		} else if (!AptNumber.equals(other.AptNumber))
			return false;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
			return false;
		if (Country == null) {
			if (other.Country != null)
				return false;
		} else if (!Country.equals(other.Country))
			return false;
		if (Postal_Code == null) {
			if (other.Postal_Code != null)
				return false;
		} else if (!Postal_Code.equals(other.Postal_Code))
			return false;
		if (StateOrProvince == null) {
			if (other.StateOrProvince != null)
				return false;
		} else if (!StateOrProvince.equals(other.StateOrProvince))
			return false;
		if (StreetAddress == null) {
			if (other.StreetAddress != null)
				return false;
		} else if (!StreetAddress.equals(other.StreetAddress))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		if(Postal_Code.length()!=0)
			return "Address : AptNumber=" + AptNumber + ", StreetAddress=" + StreetAddress + ",\n City=" + City
				+ ",\nStateOrProvince=" + StateOrProvince +"\nPostal_Code=" + Postal_Code + ",\nCountry=" + Country;
		else
			return "Address : AptNumber=" + AptNumber + ", StreetAddress=" + StreetAddress + ",\n City=" + City
					+ ",\nStateOrProvince=" + StateOrProvince + ",\nCountry=" + Country;
	}
}