package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;


import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

import java.util.LinkedList;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Money;

public abstract class ShareableResource extends Resource {
	
	public ShareableResource(String name, Money cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}
	private LinkedList<Booking> bookings = new LinkedList<Booking>();
	//protected List<Booking> listOfBookings = new ArrayList<Booking>();
    public abstract boolean isAvailable(DateTime startDate, Duration duration); 

    public abstract boolean makeBooking(DateTime StartDate, Duration duration) throws InvalidInput;

    public abstract void addBooking(DateTime startDate, Duration duration); 
	public LinkedList<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(Booking book) {
		bookings.add(book);
	}
}