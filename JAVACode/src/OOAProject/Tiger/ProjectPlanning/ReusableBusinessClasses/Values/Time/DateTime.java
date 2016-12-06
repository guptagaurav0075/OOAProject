package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import java.io.Serializable;

public class DateTime implements Serializable, Comparable<DateTime>{

    private int hour = -1; // -1 assigned to make sure that hour is assigned
    private int Minute = 0;
    private int Month = 0;
    private int Year = 0;
    private int Day = -1; //  -1 assigned to make sure that hour is assigned
    public int hourOffset;
    public int minOffset;
    private Time_Type timeType;

    //Constructor
    public DateTime(int hour, int minute, int month, int year, int day, int hourOffset, int minOffset,
			Time_Type timeType) throws InvalidInput{

		
		//Check time Type
		if( (timeType!= Time_Type.AM) && (timeType!= Time_Type.PM) && (timeType!= Time_Type.Military)){
			throw new InvalidInput("Time Type is invalid right now");
		}
		
		//check min offset
		if((minOffset!=0) && (minOffset!=30) && (minOffset!=45)){
			throw new InvalidInput("Minute offset Input Value is Invalid");
		}
		
		//check hour offset
		if(hourOffset<-12 || hourOffset>14){
			throw new InvalidInput("Hour Offset Value provided is Invalid");
		}
		
		//Chcek hour value
		if(hour<0|| hour>23){
			throw new InvalidInput("Hour value is invalid");
		}
		else{
			if((timeType == Time_Type.AM)||(timeType == Time_Type.PM)){
				if(hour>12){
					throw new InvalidInput("hour value is Invalid");
					
				}
			}
		}
		if((minute>59)||(minute<0)){
			throw new InvalidInput("Minute Value is Invalid");
		}
		if(year<0){
			throw new InvalidInput("Year valud is Invalid");
		}
		if(month<1 || month>12){
			throw new InvalidInput("Month value is Invalid");
		}
		else{
			if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)){
				if(day<1||day>31){
					throw new InvalidInput("Days value is Invalid");
				}				
			}
			else if(month==2){
				//check if leap year then number of days are not more than 29
				if(((year%4==0) && (year%100==0))||(year%400 == 0)){
					if(day<1 || day>29){
						throw new InvalidInput("Days value is invalid");
					}
				}
				// if not leap year then check number of days are not more than 28
				else{
					if(day<1 || day>28){
						throw new InvalidInput("Days value is invalid");
					}
				}
			}
			else{
				if(day<1 || day>30){
					throw new InvalidInput("Days value is Invalid");
				}
			}
		}// checked Months and Days
		this.hour = hour;
		this.Minute = minute;
		this.Month = month;
		this.Year= year;
		this.Day = day;
		this.hourOffset = hourOffset;		
		this.minOffset = minOffset;
		this.timeType = timeType; 	
		
	}// end of constructor with all values defined;
    
    
    public DateTime(int month, int year, int day) throws InvalidInput {
		
    	if(year<0){
			throw new InvalidInput("Year valud is Invalid");
		}
		if(month<1 || month>12){
			throw new InvalidInput("Month value is Invalid");
		}
		else{
			if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)){
				if(day<1||day>31){
					throw new InvalidInput("Days value is Invalid");
				}				
			}
			else if(month==2){
				//check if leap year then number of days are not more than 29
				if(((year%4==0) && (year%100==0))||(year%400 == 0)){
					if(day<1 || day>29){
						throw new InvalidInput("Days value is invalid");
					}
				}
				// if not leap year then check number of days are not more than 28
				else{
					if(day<1 || day>28){
						throw new InvalidInput("Days value is invalid");
					}
				}
			}
			else{
				if(day<1 || day>30){
					throw new InvalidInput("Days value is Invalid");
				}
			}
		}// checked Months and Days
		this.Month = month;
		this.Year = year;
		this.Day = day;
	}
    public DateTime(int month, int year) throws InvalidInput {
    	if(year<0){
			throw new InvalidInput("Year valud is Invalid");
		}
		if(month < 1 || month > 12){
			throw new InvalidInput("Month value is Invalid");
		}
		this.Month = month;
		this.Year = year;
	}


    public int getHour() {
		return hour;
	}


	public int getMinute() {
		return Minute;
	}


	public int getMonth() {
		return Month;
	}


	public int getYear() {
		return Year;
	}


	public int getDay() {
		return Day;
	}


	public int getHourOffset() {
		return hourOffset;
	}


	public int getMinOffset() {
		return minOffset;
	}


	public Time_Type getTimeType() {
		return timeType;
	}
	
	public void MilitaryTo12HoursFormat(){
		if(timeType==Time_Type.Military){
			if(hour>11){
				hour = hour-12;
				timeType=Time_Type.PM;
				//return new String(hour+":" +Minute);
			}
			else{
				timeType = Time_Type.AM;
			}
		}
		else{
			System.out.println("Already a 12 Hours Format");
		}
		
	}
	public void Hours12FormatToMilitary(){
		if(timeType==Time_Type.AM){
			//return new String(hour+":" +Minute);
		}
		else if(timeType==Time_Type.PM){
			hour =hour+12;
			//return new String(hour+":" +Minute);
		}
		else{
			System.out.println("Already in Military Format");
		}
		timeType = Time_Type.Military;
			//return null;
	}
	public DateTime add(Duration duration){
		if(hour==-1){
			try{
				DateTime other = new DateTime(this.getMonth(), this.getYear(), this.getDay());
				int otherYear = other.getYear();
				int otherMonth = other.getMonth();
				int otherDay = other.getDay();
				otherYear += duration.getNumberOfYears();
				otherMonth += duration.getNumberOfMonths();
				otherDay += duration.getNumberOfDays();
				if(Month==2){
					if(((otherYear%4==0) && (otherYear%100==0))||(otherYear%400 == 0)){
						if(otherDay >29 ){
							otherDay -=29;
							otherMonth = otherMonth+1;
						}
					}
						// if not leap year then check number of days are not more than 28
					else{
						if(otherDay > 28){
							otherDay -=28;
							otherMonth = otherMonth+1;
						}
					}
				}
				if((Month ==1)||(Month==3)||(Month==5)||(Month==7)||(Month==8)||(Month==10)||(Month==12)){
					if(otherDay>31){
						otherDay-=31;
						otherMonth+=1;
					}
				}
				if((Month ==4)||(Month==6)||(Month==9)||(Month==11)){
					if(otherDay>30){
						otherDay-=30;
						otherMonth+=1;
					}
				}
				if(otherMonth>12){
					otherMonth -= 12;
					otherYear +=1;
				
				}
				return other;	
			}catch(InvalidInput ie){
				System.out.println(ie.getMessage());
			}
		}
		return null;
	}
	
    @Override
	public String toString() {
    	if(hour!=-1){
    		String hourZero = (hour<10)?"0":"";
    		String minuteZero = (Minute<10)?"0":"";
    		if(timeType==Time_Type.Military){
    			return "[ Date(MM/DD/YYYY)=" + Month+"/"+Day+"/"+Year+ "/n" + "Time (hh:mm)  : " +hourZero+hour+ ":" + minuteZero+Minute + "UTC" + hourOffset + ":"+ minOffset+"]";	
    		}
    		else if(timeType==Time_Type.AM){
    			return "[ Date(MM/DD/YYYY)=" + Month+"/"+Day+"/"+Year+ "/n" + "Time (hh:mm)  : " +hourZero+hour+ ":" + minuteZero+Minute + "AM UTC" + hourOffset + ":"+ minOffset+"]";
    		}
    		else{
    			return "[ Date(MM/DD/YYYY)=" + Month+"/"+Day+"/"+Year+ "/n" + "Time (hh:mm)  : " +hourZero+hour+ ":" + minuteZero+Minute + "PM UTC" + hourOffset + ":"+ minOffset+"]";
    		}
    		
    	}
    	else if(Day !=-1){
    		return "[ Date(MM/DD/YYYY)=" + Month+"/"+Day+"/"+Year+ "]";
    	}
    	else
    		return "[ Date(MM/YYYY)=" + Month+"/"+Year+ "]";
	}
    
    


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if(hour != -1){
			result = prime * result + Day;
			result = prime * result + Minute;
			result = prime * result + Month;
			result = prime * result + Year;
			result = prime * result + hour;
			result = prime * result + hourOffset;
			result = prime * result + minOffset;
			result = prime * result + ((timeType == null) ? 0 : timeType.hashCode());
			return result;
		}
		else if(Day!= -1){
			result = prime * result + Day;
			result = prime * result + Month*50;
			result = prime * result + Year*750;
			return result;
		}
		else{
			result = prime * result + Month;
			result = prime * result + Year*100;
			return result;
		} 
	}


	@Override
	public boolean equals(Object obj) {
		DateTime other = (DateTime) obj;
		int otherMinute = other.getMinute();
		int otherOffsetMinute = other.getMinOffset();
		int otherHour = other.getHour();
		int otherHourOffset = other.getHourOffset();
		int otherDay = other.getDay();
		int otherMonth = other.getMonth();
		int otherYear = other.getYear();
		int Minute = this.Minute;
		int hour = this.hour;
		int Day = this.Day;
		int Month = this.Month;
		int Year = this.Year;
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		if(hour !=-1 && other.getHour()!=-1){
			hour = hour-hourOffset;
			
			if(hourOffset<0){
				Minute = Minute + minOffset;
			}
			else{
				Minute = Minute - minOffset;
			}
			otherHour = otherHour -  otherHourOffset;					
			if(otherHourOffset<0){
				otherMinute = otherMinute + otherOffsetMinute;
			}
			else{
				otherMinute = otherMinute - otherOffsetMinute;
			}
			if(hour<=0||other.getHour()<=0){
				if(hour<=0){
					if (Minute<0){
						Minute = 60 + Minute; //since Minute would be negative
						System.out.println("Minute :" + Minute );
						hour = hour -1;
					}
					if(hour<0){
							hour = 24 + hour;
							Day = Day -1;
					}
					
					if(Day<1){
						if((Month==5)||(Month==7)||(Month==8)||(Month==10)||(Month==12)){
							Month = Month-1;
							Day =30;
							
						}
						else if(Month==3){ // month will be changed to February
							Month = Month-1;
							if(((Year%4==0) && (Year%100==0))||(Year%400 == 0)){
								Day = 29;
							}
							// if not leap year then check number of days are not more than 28
							else{
								Day = 28;
							}
						}
						else{
							Day = 31;
							Month = Month-1;
							if(Month<1){ // Month will change to December
								Month = 12;
								Year = Year-1;
							}
						}
					}// end of check if day get's less than 1
				}// end of if function checking if the value of hour is zero or less than zero after offset
				if(otherHour<=0){
					if (otherMinute<0){
						otherMinute = 60 + otherMinute;
						otherHour = otherHour - 1;
					}if(otherHour<0){							
							otherHour = 24 + otherHour;
							otherDay = otherDay -1;
					}
					if(otherDay<1){
						if((otherMonth==5)||(otherMonth==7)||(otherMonth==8)||(otherMonth==10)||(otherMonth==12)){
							otherMonth = otherMonth-1;
							otherDay =30;
							
						}
						else if(otherMonth==3){ // Month will change to February since the days are less than 0 in March
							otherMonth = otherMonth-1;
							if(((otherYear%4==0) && (otherYear%100==0))||(otherYear%400 == 0)){
								otherDay = 29;
							}// if not leap year then check number of days are not more than 28
							else{
									otherDay = 28;
							}
						}
						else{
							otherMonth = otherMonth -1;
							otherDay = 31;
							if(otherMonth<1){
								otherMonth = 12;
								otherYear = otherYear -1;
							}
						}
					}
				}
			} // end of both less hours
			if(hour>0||other.getHour()>0){
				if(hour>0){
					if (Minute>59){
						Minute = Minute-60;
						hour = hour +1;
					}
					if(hour>23){
						hour = hour-24;
							Day = Day +1;
					}
					if((Month==1)||(Month==3)||(Month==5)||(Month==7)||(Month==8)||(Month==10)||(Month==12)){
						if(Day >31){
							Month = Month+1;
							Day =1;
							if(Month>12){
								Month = 1;
								Year = Year+1;
							}
						}
					}
					else if(Month==2){
						if(((Year%4==0) && (Year%100==0))||(Year%400 == 0)){
							if(Day >29 ){
								Month = Month+1;
								Day =1;
							}
						}
						// if not leap year then check number of days are not more than 28
						else{
							if(Day > 28){
								Month = Month+1;
								Day =1;
							}
						}
					}
					else{
						if(Day > 30){
							Day =1;
							Month = Month+1;
						}
					}
				}
				
				if(otherHour>0){
					if (otherMinute>59){
						otherMinute = otherMinute-60;
						otherHour = otherHour +1;
					}
					if(otherHour>23){
						otherHour = otherHour-24;
						otherDay = otherDay +1;
					}
					if((otherMonth==1)||(otherMonth==3)||(otherMonth==5)||(otherMonth==7)||(otherMonth==8)||(otherMonth==10)||(otherMonth==12)){
						if(otherDay >31){
							otherDay =1;
							otherMonth=otherMonth+1;
							if(otherMonth>12){
								otherYear = otherYear+1;
							}
						}
					}
					else if(otherMonth==2){
						if(((otherYear%4==0) && (otherYear%100==0))||(otherYear%400 == 0)){
							if(otherDay >29 ){
								otherDay =1;
								otherMonth = otherMonth+1;
							}
						}
							// if not leap year then check number of days are not more than 28
						else{
							if(otherDay > 28){
								otherDay =1;
								otherMonth = otherMonth+1;
							}
						}
					}
					else{
						if(otherDay > 30){
							otherDay =1;
							otherMonth = otherMonth+1;
						}
					}
				}
			}// end of calculation in GMT
			if((Day == otherDay) &&(hour==otherHour)&&(Minute==otherMinute)&&(Year==otherYear)&&(otherMonth==Month)){
				return true;
			}
			else
				return false;
		}
		
	
		else if(Day !=-1 && other.getDay()!=-1){
			if((Day == other.Day) && (Year==otherYear)&&(otherMonth==Month)){
				return true;
			}
			else
				return false;
		}
		else{
			if((Year==otherYear)&&(otherMonth==Month)){
				return true;
			}
			else
				return false;
		}
		
	}// end of equals function


	public int compareTo(DateTime other) {

		if (other.timeType == timeType){

			if (other.getHourOffset() != hourOffset && other.getMinOffset() != minOffset) {
				//Convert to same UTC values
			}
			if (Year < other.getYear()) {
				return -1;
			} else if (Year > other.getYear()) {
				return 1;
			} else {

				if (Month < other.getMonth()) {
					return -1;
				} else if (Month > other.getMonth()) {
					return 1;
				} else {

					if (Day < other.getDay()) {
						return -1;
					} else if (Day > other.getDay()) {
						return 1;
					} else {

						if (hour < other.getHour()) {
							return -1;
						} else if (hour > other.getHour()) {
							return 1;
						} else {

							if (Minute < other.getMinute()) {
								return -1;
							} else if (Minute > other.getMinute()) {
								return 1;
							} else {
								return 0;
							}
						}
					}
				}
			}

		}
		return Integer.MIN_VALUE;
	}




}// end of class