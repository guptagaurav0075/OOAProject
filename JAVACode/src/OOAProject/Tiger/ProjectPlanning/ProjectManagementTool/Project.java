package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool;

 
import java.util.ArrayList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.Task;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.TaskStatus;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
public class Project {

    /**
     * Default constructor
     */
    public Project() {
    }

    /**
     * 
     */
    private List<Task> tasks = new ArrayList();

    /**
     * 
     */
    private Schedule schedule;
    public void GenerateSchedule(Task finalTask, DateTime startDate) {
       List<Task> predecessor = finalTask.getPredecessor();
    	for(int index  = 0;index<predecessor.size();index++){
			Task temp = predecessor.get(index);
			if(temp.getPredecessor().size()==0){//no more predecessor
				temp.setStartDate(startDate);
				if(temp.getStatus().equals(TaskStatus.NOT_STARTED)){
					temp.setStatus(TaskStatus.IN_PROGRESS);
				}
			}
			if(temp.getStatus().equals(TaskStatus.NOT_STARTED)){
				temp.setStatus(TaskStatus.WAITING);
			}
			else{
				GenerateSchedule(temp, startDate);
			}
			
			
			
		}
    }
    

}