package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;;
public class TestDateTime {
	public static void main(String[] args) {
		try{
		//	DateTime dt = new DateTime(23, 59, 12, 2000, 31,  0, 0,Time_Type.Military);
			DateTime dt = new DateTime(1,0,12, 2016,31,-1,30, Time_Type.PM);// hour-min-month-year-day-houroffset-minoffset;
		//	DateTime dt2 = new DateTime(0,30,1, 2017,1,0,0, Time_Type.Military);;
			System.out.println(dt);
			dt.Hours12FormatToMilitary();
			//dt.MilitaryTo12HoursFormat();
			//System.out.println(dt.equals(dt2));
			System.out.println(dt);
			//System.out.println(dt2);

		}
		catch(InvalidInput E){
			System.out.println(E.getMessage());
		}	
	}
	
}
