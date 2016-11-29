package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Refrences;
import java.util.*;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.CreditCard.CreditCard;
public class Customer {
	private CreditCard creditCard;
	private Person actor;
	
	public Customer(CreditCard creditCard, Person actor) {
		this.creditCard = creditCard;
		this.actor = actor;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public Person getActor() {
		return actor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + ((creditCard == null) ? 0 : creditCard.hashCode());
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
		Customer other = (Customer) obj;
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (creditCard == null) {
			if (other.creditCard != null)
				return false;
		} else if (!creditCard.equals(other.creditCard))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [ actor=" + actor + ", creditCard=" + creditCard + "]";
	}
	
}