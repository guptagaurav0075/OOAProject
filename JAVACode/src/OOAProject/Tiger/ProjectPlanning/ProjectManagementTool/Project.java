package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool;

 
import java.util.ArrayList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.Task;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.TaskStatus;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
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
    private Schedule schedule = new Schedule();
    public void GenerateSchedule(Task finalTask, DateTime startDate) {
       List<Task> predecessor = finalTask.getPredecessor();
       boolean flag = false;
       DateTime finalEndDate = startDate;
		
       for(int index  = 0;index<predecessor.size();index++){
			Task temp = predecessor.get(index);
			if(temp.isVisited()==false){
				boolean subFlag = true; // flag to check whether all the predecessor are complete or not 
				if(temp.getPredecessor().size()==0){//no more predecessor
					temp.setStartDate(startDate);
					if(temp.getStatus().equals(TaskStatus.NOT_STARTED)){
						temp.setStatus(TaskStatus.IN_PROGRESS);
					}	
					if(temp.getStatus().equals(TaskStatus.COMPLETED)){
						subFlag = true;
					}
					else{
						subFlag = false;
					}
				
				}
				if(temp.getStatus().equals(TaskStatus.NOT_STARTED)){
					temp.setStatus(TaskStatus.WAITING);
				}	
				else{
					GenerateSchedule(temp, startDate);
				} 
			
				// Below for loop is to check if the predecessor is completed then we would show the
				// start date for the task
				for(int tempIndex=0;tempIndex<temp.getPredecessor().size(); tempIndex++){
					List<Task> checkTempPredecessor = temp.getPredecessor();
					if(checkTempPredecessor.get(tempIndex).getStatus().equals(TaskStatus.COMPLETED)){
						continue;
					}
					else{
						subFlag = false;
						break;
					}
				}// end of for loop to check if all the predecessor are complete.
			
				if(subFlag == true){
					//calculate the start date for the current task in this situation
					try{
					//for loop to find the final date for all the predecessor processes
						for(int tempIndex=0;tempIndex<temp.getPredecessor().size(); tempIndex++){
							List<Task> checkTempPredecessor = temp.getPredecessor();
							DateTime tempFinalDate = checkTempPredecessor.get(tempIndex).getStartDate();
							tempFinalDate = tempFinalDate.add(new DateTime(checkTempPredecessor.get(tempIndex).getDuration().getNumberOfMonths(), checkTempPredecessor.get(tempIndex).getDuration().getNumberOfYears(), checkTempPredecessor.get(tempIndex).getDuration().getNumberOfDays()));
							if(tempFinalDate.hashCode()>finalEndDate.hashCode()){
								finalEndDate = tempFinalDate;
							}
						}
						//end of for loop
						temp.setStartDate(finalEndDate.add(new DateTime(0,0,1)));
						String scheduleString = "Task[ Name: "+temp.getName()+"Start Date :"+temp.getStartDate()+"Status : "+temp.getStatus();
						schedule.setSchedule(scheduleString);
						finalEndDate = startDate;
						}catch(InvalidInput ie){
							System.out.println(ie.getMessage());
					}
				}// end if all the process are completed scenario
				else{
					String scheduleString = "Task[ Name: "+temp.getName()+"Start Date : Depends on Predecessor to Complete Status : "+temp.getStatus();
				}
				temp.setVisited(true);
			}
       	}
    }
}