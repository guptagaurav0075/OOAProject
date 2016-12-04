package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;


import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

import java.util.LinkedList;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;

public abstract class ShareableResource extends Resource {
	
	private LinkedList<Booking> bookings = new LinkedList<Booking>();
	//protected List<Booking> listOfBookings = new ArrayList<Booking>();
    public ShareableResource() {
    }
    public abstract Boolean isAvailable(DateTime startDate, Duration duration); 

    public abstract Boolean makeBooking(DateTime StartDate, Duration duration);

    public void addBooking(DateTime startDate, Duration duration) {
    	Booking booking = new Booking(startDate, duration);
    	bookings.add(booking);
    	for(Booking booking1 : bookings) {
            System.out.println(booking1.getStartDate());
            System.out.println(booking1.getDuration());
        }
    }
	public LinkedList<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(LinkedList<Booking> bookings) {
		this.bookings = bookings;
	}
}