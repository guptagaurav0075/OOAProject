package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Refrences;


import java.io.Serializable;
import java.util.*;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.*;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Address.Address;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Telephone.Telephone;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;



public class Person implements Serializable{	
	
	private String name;
    private String nationality;
    private Set<Telephone> phoneNumber;
    private GenderType gender;
    private Address address;
    private Title title;
    private Email emailID;
    private DateTime DOB;
    public Person(String name, String nationality, GenderType gender, Address address,
			Title title, Email emailID, DateTime dOB) throws InvalidInput {
		super();
		if(name.length()==0){
			throw new InvalidInput("Name field is empty");
		}
		if(nationality.length()==0){
			throw new InvalidInput("nationality field is empty");
		}
		if((gender!= GenderType.DO_NOT_SPECIFY)&&(gender!= GenderType.OTHER)&&(gender!= GenderType.MALE)&&(gender!= GenderType.FEMALE)){
			throw new InvalidInput("gender value is invalid");
		}
		if(dOB.getHour()!=-1||dOB.getDay()==-1){
			throw new InvalidInput("Date of Birth is not Valid");
		}
		this.name = name;
		this.nationality = nationality;
//		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.title = title;
		this.emailID = emailID;
		DOB = dOB;
		
	}
    
    public String getName() {
		return name;
	}
	public String getNationality() {
		return nationality;
	}
	public Set<Telephone> getPhoneNumber() {
		return phoneNumber;
	}
	public GenderType getGender() {
		return gender;
	}
	public Address getAddress() {
		return address;
	}
	public Title getTitle() {
		return title;
	}
	public Email getEmailID() {
		return emailID;
	}
	public DateTime getDOB() {
		return DOB;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DOB == null) ? 0 : DOB.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Person other = (Person) obj;
		if (DOB == null) {
			if (other.DOB != null)
				return false;
		} else if (!DOB.equals(other.DOB))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (emailID == null) {
			if (other.emailID != null)
				return false;
		} else if (!emailID.equals(other.emailID))
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (title != other.title)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", nationality=" + nationality + ", phoneNumber=" + phoneNumber + ", gender="
				+ gender + ", address=" + address + ", title=" + title + ", emailID=" + emailID + ", DOB=" + DOB + "]";
	}
	 
    
}