package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;;
public class TestDateTime {
	public static void main(String[] args) {
		try{
		//	DateTime dt = new DateTime(23, 59, 12, 2000, 31,  0, 0,Time_Type.Military);
			DateTime dt = new DateTime(1,0,12, 2016,31,-1,30, Time_Type.AM);// hour-min-month-year-day-houroffset-minoffset;
		//	DateTime dt2 = new DateTime(0,30,1, 2017,1,0,0, Time_Type.Military);;
			System.out.println(dt);
			DateTime dtC1 = new DateTime(4, 1991, 10);
			DateTime dtC2 = new DateTime(4, 1991, 10);
			DateTime dtC3 = dtC1.add(new Duration(5, 0, 0));
		//	System.out.println(dtC1);
			//System.out.println(dtC3);
			DateTime dtC4 = new DateTime(4, 1991, 11);
			System.out.println("equal :"+dtC1.compareTo(dtC2));
			System.out.println("Less :"+dtC1.compareTo(dtC3));
			System.out.println("More :"+dtC1.compareTo(dtC4));
			//dt.Hours12FormatToMilitary();
			//dt.MilitaryTo12HoursFormat();
			//System.out.println(dt.equals(dt2));
			//System.out.println(dt);
			//System.out.println(dt2);

		}
		catch(InvalidInput E){
			System.out.println(E.getMessage());
		}	
	}
	
}
