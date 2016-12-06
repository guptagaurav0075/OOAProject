package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;


import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

public class Booking {

    public Booking(DateTime startDate, Duration duration){
    	this.startDate = startDate;
    	this.duration = duration;
    }
    
	private Duration duration;
	private DateTime startDate;
	
    public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

    public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	 @Override
     public String toString() {
         return "Booking: startDate = " + startDate + "; Duration = " + duration;
     }
}
