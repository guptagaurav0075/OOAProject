package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;


import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Money;

public abstract class ShareableResource extends Resource {
	
	public ShareableResource(String name, Money cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}
	private List<Booking> bookings = new ArrayList<Booking>();
	//protected List<Booking> listOfBookings = new ArrayList<Booking>();
    public abstract boolean isAvailable(DateTime startDate, Duration duration); 

    public abstract boolean makeBooking(DateTime StartDate, Duration duration) throws InvalidInput;

    public abstract void addBooking(DateTime startDate, Duration duration); 

	public ArrayList<Booking> getBookings() {
		return (ArrayList<Booking>) bookings;
	}

	public void setBookings(Booking book) {
		bookings.add(book);
	}

}