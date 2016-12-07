package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool;

 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.CompositeTask;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.SimpleTask;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.Task;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.TaskStatus;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Booking;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Equipment;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Labor;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Resource;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.ShareableResource;
public class Project extends CompositeTask{

    /**
     * Default constructor
     */
	List<Task> mainTasks = null;
	public Project(String name){
		super(name);
	}
    
    public void addTask(Task subTask){
   		mainTasks.add(subTask);
    }  
    /**
     * 
     */
    private Schedule schedule = new Schedule();
    public void GenerateSchedule(Task finalTask, DateTime startDate) throws InvalidInput{
       if(finalTask instanceof SimpleTask){
    	   List<Task> predecessor = finalTask.getPredecessor();
           boolean flag = false;
           DateTime finalEndDate = startDate;
    		
           for(int index  = 0;index<predecessor.size();index++){
    			Task temp = predecessor.get(index);
    			if(temp.isVisited()==false){ // this means that task is never visited
    				boolean subFlag = false; // flag to check whether all the predecessor are complete or not 
    				if(temp.getPredecessor().size()==0){//no more predecessor
    					temp.setStartDate(startDate);
    					if(temp.getStatus().equals(TaskStatus.COMPLETED)){
    						subFlag = true;
    					}
    				}
    				else{
    					GenerateSchedule(temp, startDate);
    				}
    				

    				// Below for loop is to check if the predecessor is completed then we would set the start date of successor task
    				for(int tempIndex=0;tempIndex<temp.getPredecessor().size(); tempIndex++){
    					List<Task> checkTempPredecessor = temp.getPredecessor();
    					if(checkTempPredecessor.get(tempIndex).getStatus().equals(TaskStatus.COMPLETED)){
    						continue;
    					}
    					else{
    						String error="Task "+ temp.getName()+ "is not completed";
    						subFlag = false;
    						throw new InvalidInput(error);
    						
    					}
    				}// end of for loop to check if all the predecessor are complete.
    				if(subFlag == true){
    					//calculate the start date for the current task in this situation
    					try{
    					//for loop to find the final date for all the predecessor processes
    						finalEndDate = temp.getPredecessor().get(0).getStartDate();
    						for(int tempIndex=0;tempIndex<temp.getPredecessor().size(); tempIndex++){
    						
    							DateTime tempFinalDate = temp.getPredecessor().get(tempIndex).getStartDate();
    							tempFinalDate = tempFinalDate.add(temp.getPredecessor().get(tempIndex).getDuration());//new DateTime(checkTempPredecessor.get(tempIndex).getDuration().getNumberOfMonths(), checkTempPredecessor.get(tempIndex).getDuration().getNumberOfYears(), checkTempPredecessor.get(tempIndex).getDuration().getNumberOfDays()));
    							if(finalEndDate.compareTo(tempFinalDate)<0){
    								finalEndDate = tempFinalDate;
    							}
    						}
    						//end of for loop
    						temp.setStartDate(finalEndDate.add(new Duration(1,0,0)));
    						String scheduleString = "Task[ Name: "+temp.getName()+"Start Date :"+temp.getStartDate()+"Status : "+temp.getStatus();
    						schedule.setSchedule(scheduleString);
    						finalEndDate = temp.getStartDate();
    						}catch(InvalidInput ie){
    							System.out.println(ie.getMessage());
    					}
    				}// end if all the process are completed scenario
    				//check for resources if they are available during the startDate or not
    				
    				else{ // subtask is not complete
    					for(int tempIndex=0;tempIndex<temp.getPredecessor().size(); tempIndex++){
    						if(temp.getPredecessor().get(tempIndex).getStatus().equals(TaskStatus.COMPLETED)){
    							continue;
    						}
    						else{
    							List<Resource> resources = temp.getPredecessor().get(tempIndex).getResources();
    							for(int indexResource = 0; indexResource<resources.size(); indexResource++){
    								if(resources.get(indexResource) instanceof Labor || resources.get(indexResource) instanceof Equipment){
    									ShareableResource tempResource = (ShareableResource) resources.get(indexResource);
    									if(resources.get(indexResource) instanceof Labor){
    	    								tempResource =  (Labor) resources.get(indexResource);
    	    							}
    	    							else if(resources.get(indexResource) instanceof Equipment){
    	    								tempResource = (Equipment) resources.get(indexResource);
    	    							}
    									LinkedList<Booking> bookingList  = tempResource.getBookings();
    									DateTime StartDateOfTask = temp.getPredecessor().get(tempIndex).getStartDate();
    									DateTime FinalDateOfTask =StartDateOfTask;
    									FinalDateOfTask= FinalDateOfTask.add(temp.getPredecessor().get(tempIndex).getDuration());
    									boolean bookingFlag = false; // to check if booking is available and task status is not changed
    									for(int indexBookingList = 0; indexBookingList<bookingList.size();indexBookingList++){
    										DateTime bookingStartDate = bookingList.get(indexBookingList).getStartDate();
    										DateTime bookingEndDate = bookingStartDate;
    										bookingEndDate = bookingEndDate.add(bookingList.get(indexBookingList).getDuration());
    										if(StartDateOfTask.compareTo(bookingStartDate)<=0 && FinalDateOfTask.compareTo(bookingEndDate)>=0){
    											bookingFlag = true; // booking is available and task is completed but the status is not changed;
    											break;
    										}
    									}
    									
    									if(bookingFlag==true){
    										// booking is available and throw a exception to user to ask for to change the status of the task;
    										String error="Task "+temp.getPredecessor().get(tempIndex).getName()+" is completed kindly change the status of the task to completed";
    										throw new InvalidInput(error);
    									}
    									else{
    										String error="Task "+temp.getPredecessor().get(tempIndex).getName()+" has no resources kindly change the status to waiting or assign a resource";
    										throw new InvalidInput(error);
    									}
    								}
    								else{
    									continue;
    								}
    							}
    						}
							
						}
    					
    				}
    				temp.setVisited(true);
    			}
           	}   
       }
       
    }
}