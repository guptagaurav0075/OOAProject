package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;


import java.util.LinkedList;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Money;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

/**
 * 
 */
public class Equipment extends ShareableResource {

    /**
     * Default constructor
     */

    public Equipment(String name, Money cost) {
		super(name, cost);
	}

    public Equipment(String name, Money cost, Booking book) throws InvalidInput{
    	super(name, cost);
    	try{
    		makeBooking(book.getStartDate(), book.getDuration());
		}catch(InvalidInput ie){
			System.out.println(ie.getMessage());
		}
	}
    public Equipment(String name, Money cost, DateTime startDate, Duration duration) throws InvalidInput{
    	super(name, cost);
    	try{
    		makeBooking(startDate, duration);
		}catch(InvalidInput ie){
			System.out.println(ie.getMessage());
		}
	}

	@Override
	public boolean makeBooking(DateTime StartDate, Duration duration) throws InvalidInput{
		if (isAvailable(StartDate, duration)){
			addBooking(StartDate, duration);
			System.out.println("Booking Made Successfully");
			return true;
		}else{
			throw new InvalidInput("Resource is already booked, try another date");
		}
    }
	@Override
	public boolean isAvailable(DateTime startDate, Duration duration) {
		LinkedList<Booking> bookings = getBookings();

		if(bookings.size()==0){
			return true;
		}
		else{
			boolean flag = true; // it means the resource is not booked
			DateTime tempStartDate = startDate;
			DateTime tempEndDate;
			try {
				tempEndDate = new DateTime(startDate.getMonth(),startDate.getYear(),startDate.getDay());
				tempEndDate = tempEndDate.add(duration);

//				System.out.println(tempStartDate);
//				System.out.println(tempEndDate);
//
//				System.out.println(tempStartDate.compareTo(tempEndDate));

				checkBookings: for(int index = 0; index < bookings.size(); index++){
				DateTime bookingDate = bookings.get(index).getStartDate();
				Duration endBookDuration = bookings.get(index).getDuration();
				DateTime bookEndDate = bookingDate.add(endBookDuration);

//				System.out.println(bookingDate);
//				System.out.println(bookEndDate);

				if (!((tempStartDate.compareTo(bookingDate) > 0) && (tempStartDate.compareTo(bookEndDate) < 0))
						|| !((tempEndDate.compareTo(bookingDate) > 0) && (tempEndDate.compareTo(bookEndDate) < 0))) {
					flag = false;
					break checkBookings;
				}
			}
			} catch (InvalidInput e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
			// end of checking whether the booking is available or not;	
	}
	@Override
	public void addBooking(DateTime startDate, Duration duration) {
		Booking book = new Booking(startDate, duration);
		this.setBookings(book);
	}

    
}