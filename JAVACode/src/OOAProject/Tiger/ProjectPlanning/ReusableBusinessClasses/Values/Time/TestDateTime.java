package OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time;

public class TestDateTime {
	public static void main(String[] args) {
		try{
		//	DateTime dt = new DateTime(23, 59, 12, 2000, 31,  0, 0,Time_Type.Military);
			DateTime dt = new DateTime(23,30,10, 2011,20,-2,0, Time_Type.Military);// hour-min-month-year-day-houroffset-minoffset;
			DateTime dt2 = new DateTime(23,0,10, 2011,20,-2,30, Time_Type.Military);;
			System.out.println(dt.equals(dt2));
			System.out.println(dt);
			System.out.println(dt2);

		}
		catch(Exception E){
		
		}	
	}
	
}
