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
		if (isAvailable(StartDate, duration ) == true){
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
			boolean flag = false; // it means the resource is not booked
			try{
				DateTime tempStartDate = startDate;
				DateTime tempEndDate = new DateTime(duration.getNumberOfMonths(), duration.getNumberOfYears(), duration.getNumberOfDays());
				tempEndDate = tempEndDate.add(startDate);
				
			
				for(int index = 0; index<bookings.size();index++){
					while(flag!=true){
						if(bookings.get(index).getStartDate().equals(tempStartDate)){
							flag = true;
							break;
						}
						else{
							DateTime OneDayAddition = new DateTime(0,0,1);// month-year-day
							tempStartDate = tempStartDate.add(OneDayAddition);//incremented by one day
							if(tempStartDate.equals(tempEndDate)){
								if(bookings.get(index).getStartDate().equals(tempStartDate)){
									flag = true;
									break;
								}
								else{
									break;
								}
							}
						}// end of checking for one day
					}// end of checking for one booking;
					if(flag == true){
						break;
					}
				}
			}catch(InvalidInput ie){
				System.out.println(ie.getMessage());
			}
			if(flag == true){
				return false; // there is a booking on that day
			}
			else{
				return true;
			}
		}// end of checking whether the booking is available or not;	
	}
	@Override
	public void addBooking(DateTime startDate, Duration duration) {
		Booking book = new Booking(startDate, duration);
		super.setBookings(book);
	}

    
}