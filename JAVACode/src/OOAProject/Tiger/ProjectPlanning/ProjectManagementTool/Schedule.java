package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool;

/**
 * 
 */
public class Schedule {

	String schedule;
    public Schedule() {
    }
	
	public void setSchedule(String schedule) {
		this.schedule = this.schedule + schedule +"\n";
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return schedule;
	}
    

}