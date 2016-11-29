package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;;
public class Duration {
	private int NumberOfDays = -1;
    private int NumberOfMonths = -1;
    private int NumberOfYears = -1;
    private int NumberOfHours = -1;
    private int NumberOfMinutes = -1;
	
    public Duration(int numberOfDays) throws InvalidInput{
    	if(numberOfDays>31 ||numberOfDays<0){
    		throw new InvalidInput("Days value entered is Incorrect");
    	}
		NumberOfDays = numberOfDays;
	}
    
    


	public Duration(int numberOfHours, int numberOfMinutes) throws InvalidInput{
		if(numberOfHours>23 || numberOfHours<0){
			throw new InvalidInput("Hours value entered is Incorrect");
		}
		if(numberOfMinutes<0||numberOfMinutes>59){
			throw new InvalidInput("Minutes value entered is Incorrect");
		}
		NumberOfHours = numberOfHours;
		NumberOfMinutes = numberOfMinutes;
	}
	



	public Duration(int numberOfDays, int numberOfHours, int numberOfMinutes) throws InvalidInput {
		if(numberOfDays>31 ||numberOfDays<0){
    		throw new InvalidInput("Days value entered is Incorrect");
    	}
		if(numberOfHours>23 || numberOfHours<0){
			throw new InvalidInput("Hours value entered is Incorrect");
		}
		if(numberOfMinutes<0||numberOfMinutes>59){
			throw new InvalidInput("Minutes value entered is Incorrect");
		}
		NumberOfDays = numberOfDays;
		NumberOfHours = numberOfHours;
		NumberOfMinutes = numberOfMinutes;
	}
	




	public Duration(int numberOfDays, int numberOfMonths, int numberOfHours, int numberOfMinutes) throws InvalidInput{
		if(numberOfDays>31 ||numberOfDays<0){
    		throw new InvalidInput("Days value entered is Incorrect");
    	}
		if(numberOfMonths<0 || numberOfMonths>12){
			throw new InvalidInput("Months value Entered is Incorrect");
		}
		if(numberOfHours>23 || numberOfHours<0){
			throw new InvalidInput("Hours value entered is Incorrect");
		}
		if(numberOfMinutes<0||numberOfMinutes>59){
			throw new InvalidInput("Minutes value entered is Incorrect");
		}
		NumberOfDays = numberOfDays;
		NumberOfMonths = numberOfMonths;
		NumberOfHours = numberOfHours;
		NumberOfMinutes = numberOfMinutes;
	}
	
	public Duration(int numberOfDays, int numberOfMonths, int numberOfYears, int numberOfHours, int numberOfMinutes) throws InvalidInput{
		if(numberOfDays>31 ||numberOfDays<0){
    		throw new InvalidInput("Days value entered is Incorrect");
    	}
		if(numberOfMonths<0 || numberOfMonths>12){
			throw new InvalidInput("Months value Entered is Incorrect");
		}
		if(numberOfYears<0){
			throw new InvalidInput("Year value entered is Incorrect");
		}
		if(numberOfHours>23 || numberOfHours<0){
			throw new InvalidInput("Hours value entered is Incorrect");
		}
		if(numberOfMinutes<0||numberOfMinutes>59){
			throw new InvalidInput("Minutes value entered is Incorrect");
		}
		NumberOfDays = numberOfDays;
		NumberOfMonths = numberOfMonths;
		NumberOfYears = numberOfYears;
		NumberOfHours = numberOfHours;
		NumberOfMinutes = numberOfMinutes;
	}

	

	@Override
	public String toString() {
		if(NumberOfHours==-1 &&NumberOfMinutes ==-1 && NumberOfMonths ==-1 && NumberOfYears == -1){
			return "Duration [NumberOfDays =" + NumberOfDays+"]";
		}
		else if(NumberOfDays==-1 && NumberOfMonths ==-1 && NumberOfYears == -1){
			return "Duration [hh:mm] - "+NumberOfHours+":"+NumberOfMinutes;
		}
		else if(NumberOfMonths ==-1 && NumberOfYears == -1){
			return "Duration [Days : " +NumberOfDays+"] [hh:mm] ["+NumberOfHours+":"+NumberOfMinutes+"]";
		}
		else if(NumberOfYears == -1){
			return "Duration [DD/MM] : " +NumberOfDays+"/"+NumberOfMonths+"] [hh:mm] ["+NumberOfHours+":"+NumberOfMinutes+"]";
		}
		else{
			return "Duration [NumberOfDays=" + NumberOfDays + ", NumberOfMonths=" + NumberOfMonths + ", NumberOfYears="
					+ NumberOfYears + ", NumberOfHours=" + NumberOfHours + ", NumberOfMinutes=" + NumberOfMinutes + "]";
		}		
	}




	

    
    public Duration add(Duration other) {
        // TODO implement here
        return null;
    }

}
