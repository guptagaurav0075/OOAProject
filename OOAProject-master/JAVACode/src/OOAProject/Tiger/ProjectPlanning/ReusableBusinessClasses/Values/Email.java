package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values;
import java.io.Serializable;
import java.util.*;

public class Email implements Serializable{
    private String UserName;
    private String HostName ;
	private String DomainName = "com";
    public Email(String userName, String hostName) throws InvalidInput {
		if(userName.length()==0){
			throw new InvalidInput("Username Value is left Blank");
		}
		if(hostName.length()==0){
			throw new InvalidInput("Host Name Value is left Blank");
		}
		
		UserName = userName;
		HostName = hostName;
	}
	public Email(String userName, String domainName, String hostName) throws InvalidInput {
		
		if(userName.length()==0){
			throw new InvalidInput("Username Value is left Blank");
		}
		if(DomainName.length()==0){
			throw new InvalidInput("Domain name Value is left Blank");
		}
		if(hostName.length()==0){
			throw new InvalidInput("Host Name value is left Blank");
		}
		UserName = userName;
		DomainName = domainName;
		HostName = hostName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DomainName == null) ? 0 : DomainName.hashCode());
		result = prime * result + ((HostName == null) ? 0 : HostName.hashCode());
		result = prime * result + ((UserName == null) ? 0 : UserName.hashCode());
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
		Email other = (Email) obj;
		if (DomainName == null) {
			if (other.DomainName != null)
				return false;
		} else if (!DomainName.equals(other.DomainName))
			return false;
		if (HostName == null) {
			if (other.HostName != null)
				return false;
		} else if (!HostName.equals(other.HostName))
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return UserName + "@" + HostName + "." + DomainName ;
	}
}