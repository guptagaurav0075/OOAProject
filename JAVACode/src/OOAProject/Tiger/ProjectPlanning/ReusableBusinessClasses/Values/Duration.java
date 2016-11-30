package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values;

import java.time.Year;

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
			return "Duration [DD/MM/YYYY] =" + NumberOfDays + "/" + NumberOfMonths + "/"
					+ NumberOfYears + " ,\t [hh:mm]=" + NumberOfHours + ":" + NumberOfMinutes ;
		}		
	}
	
	
	
    public int getNumberOfDays() {
		return NumberOfDays;
	}




	public int getNumberOfMonths() {
		return NumberOfMonths;
	}




	public int getNumberOfYears() {
		return NumberOfYears;
	}




	public int getNumberOfHours() {
		return NumberOfHours;
	}




	public int getNumberOfMinutes() {
		return NumberOfMinutes;
	}




	public Duration add(Duration other) {
        int otherMinutes = other.getNumberOfMinutes();
        int otherHours = other.getNumberOfHours();
        int otherDays = other.getNumberOfDays();
        int otherYears = other.getNumberOfYears();
        int otherMonths = other.getNumberOfMonths();
        if(NumberOfYears !=-1 && otherYears != -1){
        	if(NumberOfMonths==-1&&otherMonths == -1){ //month of both are not set
        		if(otherDays==-1 && NumberOfDays == -1){ // days of both are not set
        			otherMinutes = otherMinutes +NumberOfMinutes;
        			otherHours = otherHours + NumberOfHours;
        			if(otherMinutes > 59){
        				otherMinutes = otherMinutes - 60;
        				otherHours = otherHours +1;
        			}
        			if(otherHours>23){
        				otherDays = 1;
        				otherHours = otherHours-24;
        				try{
        					Duration temp = new Duration(otherDays, otherHours, otherMinutes);
        					return temp;
        				}
        				catch(InvalidInput ie){
        					ie.printStackTrace();
        				}
        			}
        			else{
        				try{
        					Duration temp = new Duration(otherHours, otherMinutes);
        					return temp;
        				}
        				catch(InvalidInput ie){
        					ie.printStackTrace();
        				}
        			}
        		}//end of number of days if no days defined
        		else{
        			if(otherDays == -1){
        				otherDays = 0;
        			}
        			if(NumberOfDays == -1){
        				NumberOfDays = 0;
        			}
        			otherDays = otherDays + NumberOfDays;
    				
        			if(otherHours == -1 && NumberOfHours == -1){
        				if(otherDays>31){
        					otherMonths = 1;
        					otherDays = otherDays - 31;
        					try{
            					Duration temp = new Duration(otherDays, otherMonths, 0, 0);
            					return temp;
            				}
            				catch(InvalidInput ie){
            					ie.printStackTrace();
            				}
        				}
        				else{
        					try{
            					Duration temp = new Duration(otherDays);
            					return temp;
            				}
            				catch(InvalidInput ie){
            					ie.printStackTrace();
            				}
        				}
        			}
        			else{
        				if(otherHours == -1){
        					otherHours = 0;
        					otherMinutes = 0;
        				}
        				if(NumberOfHours == -1){
        					NumberOfHours = 0;
        					NumberOfMinutes = 0;
        				}
        				otherMinutes = otherMinutes + NumberOfMinutes;
        				otherHours = otherHours + NumberOfHours;
        				if(otherMinutes>59){
        					otherMinutes = otherMinutes - 60;
        					otherHours = otherHours+1;
        				}
        				if(otherHours>23){
        					otherHours = otherHours - 24;
        					otherDays = otherDays + 1;
        				}
        				if(otherDays > 31){
        					otherDays = otherDays - 31;
        					otherMonths = 1;
        					try{
            					Duration temp = new Duration(otherDays, otherMonths, otherHours, otherMinutes);
            					return temp;
            				}
            				catch(InvalidInput ie){
            					ie.printStackTrace();
            				}
        				}
        				else{
        					try{
            					Duration temp = new Duration(otherDays, otherHours, otherMinutes);
            					return temp;
            				}
            				catch(InvalidInput ie){
            					ie.printStackTrace();
            				}
        				}
        				
        			}
        		}// end if days is defined
        		
        	}//end if no month is defined
        	else{
        		if(otherMonths ==-1){
        			otherMonths = 0;
        			
        		}
        		if(NumberOfMonths == -1){
        			NumberOfMonths = 0;
        		}
        		otherMonths = otherMonths + NumberOfMonths;
        		otherMinutes = otherMinutes + NumberOfMinutes;
        		otherDays = otherDays +NumberOfDays;
        		otherHours = otherHours + NumberOfHours;
        		if(otherMinutes>59){
        			otherMinutes = otherMinutes - 60;
        			otherHours = otherHours +1;      			
        		}
        		if(otherHours>23){
        			otherHours = otherHours - 24;
        			otherDays = otherDays + 1;
        		}
        		if(otherDays > 31){
        			otherDays -= 31;
        			otherMonths += 1;
        		}
        		if(otherMonths>12){
        			otherMonths -= 12;
        			otherYears = 1;
        			try{
    					Duration temp = new Duration(otherDays,otherMonths, otherYears, otherHours, otherMinutes);
    					return temp;
    				}
    				catch(InvalidInput ie){
    					ie.printStackTrace();
    				}
        		}
        		else{
        			try{
    					Duration temp = new Duration(otherDays, otherMonths, otherHours, otherMinutes);
    					return temp;
    				}
    				catch(InvalidInput ie){
    					ie.printStackTrace();
    				}
        		}
        	}//end if month is defined or not
        }//end if no year is defined
        else{
        	if(otherYears == -1){
        		otherYears = 0;
        	}
        	if(NumberOfYears == -1){
        		NumberOfYears = 0;
        	}
        	otherYears += NumberOfYears;
        	otherMonths = otherMonths + NumberOfMonths;
    		otherMinutes = otherMinutes + NumberOfMinutes;
    		otherDays = otherDays +NumberOfDays;
    		otherHours = otherHours + NumberOfHours;
    		if(otherMinutes>59){
    			otherMinutes = otherMinutes - 60;
    			otherHours = otherHours +1;      			
    		}
    		if(otherHours>23){
    			otherHours = otherHours - 24;
    			otherDays = otherDays + 1;
    		}
    		if(otherDays > 31){
    			otherDays -= 31;
    			otherMonths += 1;
    		}
    		if(otherMonths>12){
    			otherMonths -= 12;
    			otherYears += 1;  			
    		}
    		try{
				Duration temp = new Duration(otherDays,otherMonths, otherYears, otherHours, otherMinutes);
				return temp;
			}
			catch(InvalidInput ie){
				ie.printStackTrace();
			}
        }//end if one of the year is defined
        return null;
    } // end of add function
}
