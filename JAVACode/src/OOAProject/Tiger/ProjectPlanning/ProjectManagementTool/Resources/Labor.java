package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;

import java.util.LinkedList;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Refrences.Person;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Money;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
/**
 * 
 */
public class Labor extends ShareableResource {



    public Labor(String name, Money cost, String laborId, Person actor) {
		super(name, cost);
		this.laborId = laborId;
		this.actor = actor;
	}

    public Labor(String name, Money cost, String laborId, Person actor, DateTime StartDate, Duration duration) throws InvalidInput {
		super(name, cost);
		try{
			this.laborId = laborId;
			this.actor = actor;
			makeBooking(StartDate, duration);
		}catch(InvalidInput ie){
			System.out.println(ie.getMessage());
		}
	}
	
    public Labor(String name, Money cost, String laborId, Person actor, Booking book) throws InvalidInput {
		super(name, cost);
		try{
			this.laborId = laborId;
			this.actor = actor;
			makeBooking(book.getStartDate(), book.getDuration());
		}catch(InvalidInput ie){
			System.out.println(ie.getMessage());
		}
	}

	private String laborId;
    private Person actor;
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
			boolean flag = true; // it means the resource is not booked
			try{
				DateTime tempStartDate = startDate;
				DateTime tempEndDate = new DateTime(duration.getNumberOfMonths(), duration.getNumberOfYears(), duration.getNumberOfDays());
				tempEndDate = tempEndDate.add(startDate);

				System.out.println(tempStartDate);
				System.out.println(tempEndDate);

				System.out.println(tempStartDate.compareTo(tempEndDate));

				checkBookings: for(int index = 0; index < bookings.size(); index++){
					DateTime bookingDate = bookings.get(index).getStartDate();
					Duration endBookDuration = bookings.get(index).getDuration();
					DateTime bookDateDuration = new DateTime(endBookDuration.getNumberOfMonths(), endBookDuration.getNumberOfYears(), endBookDuration.getNumberOfDays());
					DateTime bookEndDate = bookingDate.add(bookDateDuration);

					System.out.println(bookingDate);
					System.out.println(bookEndDate);

					if (!((tempStartDate.compareTo(bookingDate) > 0) && (tempStartDate.compareTo(bookEndDate) < 0))
							|| !((tempEndDate.compareTo(bookingDate) > 0) && (tempEndDate.compareTo(bookEndDate) < 0))) {

						flag = false;
						break checkBookings;
					}
				}
			}
			catch(InvalidInput ie){
				System.out.println(ie.getMessage());
			}

			return flag;
		}// end of checking whether the booking is available or not;
	}
	@Override
	public void addBooking(DateTime startDate, Duration duration) {
		Booking book = new Booking(startDate, duration);
		super.setBookings(book);
	}
}