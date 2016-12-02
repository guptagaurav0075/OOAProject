package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;

import java.util.*;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;

public abstract class ShareableResource extends Resource {
	
	protected List<Booking> listOfBookings = new ArrayList<Booking>();
    public ShareableResource() {
    }
    public abstract Boolean isAvailable(DateTime startDate, Duration duration); 

    public abstract Boolean makeBooking(DateTime StartDate, Duration duration);

    public void addBooking(DateTime startDate, Duration duration) {
    	Booking booking = new Booking(startDate, duration);
    	listOfBookings.add(booking);
    	for(Booking booking1 : listOfBookings) {
            System.out.println(booking1.getStartDate());
            System.out.println(booking1.getDuration());
        }
    }
	public List<Booking> getBookings() {
		return listOfBookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.listOfBookings = bookings;
	}
}