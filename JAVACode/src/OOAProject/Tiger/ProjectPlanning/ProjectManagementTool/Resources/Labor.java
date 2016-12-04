package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;

import java.util.LinkedList;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Refrences.Person;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
/**
 * 
 */
public class Labor extends ShareableResource {


	public Labor() {
    }

    private String laborId;
    private Person actor;
   // int bookingsCount = ookings.size();
    public Boolean makeBooking(DateTime startDate, Duration duration){
		if (isAvailable(startDate, duration ) == true){
			addBooking(startDate, duration);
		}
		
		return null;
    }
	@Override
	public Boolean isAvailable(DateTime startDate, Duration duration) {
		LinkedList<Booking> bookings = getBookings();
		if(bookings.size()==0){
			return true;
		}
		else{
			for(int index = 0; index<bookings.size();index++){
				if(bookings.get(index).getStartDate().equals(startDate)){
					return false;
				}
				if(bookings.get(index).getStartDate().getYear() == startDate.get)
			}
		}
		for(int i=0; i<bookingsCount; i++){
			if (listOfBookings.get(i).getStartDate() == startDate){
				// check for booking before startDate
				break;
				}	
		}
		return null;
	}
}