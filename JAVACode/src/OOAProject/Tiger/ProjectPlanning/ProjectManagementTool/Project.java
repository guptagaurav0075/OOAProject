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
	List<Task> mainTasks = new ArrayList<Task>();
	public Project(String name){
		super(name);
	}
    
    public void addTask(Task subTask){
   		mainTasks.add(subTask);
    }  
    /**
     * generate schedule will generate the schedule if all the predecessor task are complete 
     * otherwise it will throw an error about a resource not available and seek the user
     * to provide the 
     */
    private Schedule schedule = new Schedule();
    
    public Schedule getSchedule() {
		return schedule;
	}

	public void GenerateSchedule(Task finalTask, DateTime startDate) throws InvalidInput{
       if(finalTask instanceof SimpleTask){
    	   finalTask = (SimpleTask)finalTask;
    	   List<Task> predecessor = finalTask.getPredecessor();
           DateTime finalEndDate = startDate;
    		
           for(int index  = 0;index<predecessor.size();index++){
    			Task temp = predecessor.get(index);
    			if(temp.isVisited()==false){ // this means that task is never visited
    				boolean subFlag = false; // flag to check whether all the predecessor are complete or not 
    				if(temp.getPredecessor().size()==0){//no more predecessor
    					temp.setStartDate(startDate);
    					if(temp.getStatus().equals(TaskStatus.COMPLETED)){
    						temp.setEndTime(startDate.add(temp.getDuration()));
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
    					// subFlag = true means all the predecessor task are complete
    					//calculate the start date for the current task in this situation
    					try{
    					//for loop to find the final date for all the predecessor processes
    						finalEndDate = temp.getStartDate().add(temp.getDuration());
    						for(int tempIndex=0;tempIndex<temp.getPredecessor().size(); tempIndex++){
    						
    							DateTime tempFinalDate = temp.getPredecessor().get(tempIndex).getStartDate(); // variable used to find the final date of each predecessor task
    							tempFinalDate = tempFinalDate.add(temp.getPredecessor().get(tempIndex).getDuration());//new DateTime(checkTempPredecessor.get(tempIndex).getDuration().getNumberOfMonths(), checkTempPredecessor.get(tempIndex).getDuration().getNumberOfYears(), checkTempPredecessor.get(tempIndex).getDuration().getNumberOfDays()));
    							if(finalEndDate.compareTo(tempFinalDate)<0){
    								finalEndDate = tempFinalDate;
    							}
    						}
    						for(int tempIndex = 0; tempIndex<temp.getPredecessor().size(); tempIndex++){
    							temp.getPredecessor().get(tempIndex).setEndTime(finalEndDate);
    						}
    						//end of for loop
    						// set the start date one day after the final end date of the task
    						temp.setStartDate(finalEndDate.add(new Duration(1,0,0)));
    						String scheduleString = "Task[ Name: "+temp.getName()+"Start Date :"+temp.getStartDate()+"Status : "+temp.getStatus();
    						schedule.setSchedule(scheduleString);
    						finalEndDate = temp.getStartDate();
    						temp.setEndTime(getStartDate().add(temp.getDuration()));
    						}catch(InvalidInput ie){
    							System.out.println(ie.getMessage());
    					}
    				}// end if all the process are completed scenario
    				//check for resources if they are available during the startDate or not
    				
    				else{ // subtask is not complete
    					schedule = null;
    					for(int tempIndex = 0; tempIndex<temp.getPredecessor().size(); tempIndex++){
    						temp.getPredecessor().get(tempIndex).setVisited(false); // to set the predecessor to false so that they can be visited again next time;
    					}
    					for(int tempIndex=0;tempIndex<temp.getPredecessor().size(); tempIndex++){
    						if(temp.getPredecessor().get(tempIndex).getStatus().equals(TaskStatus.COMPLETED)){
    							continue;
    						}
    						else{
    							List<Resource> resources = ((SimpleTask) temp.getPredecessor().get(tempIndex)).getResources();
    							for(int indexResource = 0; indexResource<resources.size(); indexResource++){
    								if(resources.get(indexResource) instanceof Labor || resources.get(indexResource) instanceof Equipment){
    									ShareableResource tempResource = (ShareableResource) resources.get(indexResource);
    									if(resources.get(indexResource) instanceof Labor){
    	    								tempResource =  (Labor) resources.get(indexResource);
    	    							}
    	    							else if(resources.get(indexResource) instanceof Equipment){
    	    								tempResource = (Equipment) resources.get(indexResource);
    	    							}
    									List<Booking> bookingList  = tempResource.getBookings();
    									DateTime StartDateOfTask = temp.getPredecessor().get(tempIndex).getStartDate();
    									DateTime FinalDateOfTask =StartDateOfTask;
    									FinalDateOfTask= FinalDateOfTask.add(temp.getPredecessor().get(tempIndex).getDuration());
    									boolean bookingFlag = false; // to check if booking is available and task status is not changed
    									for(int indexBookingList = 0; indexBookingList<bookingList.size();indexBookingList++){
    										DateTime bookingStartDate = bookingList.get(indexBookingList).getStartDate();
    										DateTime bookingEndDate = bookingStartDate;
    										bookingEndDate = bookingEndDate.add(bookingList.get(indexBookingList).getDuration());
    										if(StartDateOfTask.compareTo(bookingStartDate)<=0 && FinalDateOfTask.compareTo(bookingEndDate)>=0){
    											temp.getPredecessor().get(tempIndex).setStartDate(bookingStartDate);
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
       else{
    	   // if it is a composite task then traverse through all the subtasks;
    	  
    	   List<Task> subTasks = ((CompositeTask) finalTask).getSubtasks();
    	   DateTime finalEndTime = startDate;// to set the final end date time of composite task
    	   if(finalTask.isVisited()==false){
    		   if(finalTask.getPredecessor().size()!=0){
    			   DateTime tempFinalEndTime = finalEndTime;
    			   for(int index = 0; index<finalTask.getPredecessor().size(); index++){
    				   GenerateSchedule(finalTask.getPredecessor().get(index), startDate);
    			   }
    			   //loop to find the end date that was the maximum among the predecessor task
    			   for(int index = 0; index<finalTask.getPredecessor().size(); index++){
    				   tempFinalEndTime = finalTask.getPredecessor().get(index).getEndTime();
    				   if(finalEndTime.compareTo(tempFinalEndTime)<0){
    					   finalEndTime = tempFinalEndTime;
    	    			}
    			   }
    			   //loop to set the final end date time for the predecessor task
    			   for(int index = 0; index<finalTask.getPredecessor().size(); index++){
    				   finalTask.getPredecessor().get(index).setEndTime(finalEndTime);
    			   }
    			   finalTask.setStartDate(finalEndTime.add(new Duration(1, 0, 0)));
    		   }
    		   else{
    			   for(int index =0; index<subTasks.size();index++){
    				   GenerateSchedule(subTasks.get(index), startDate);
    			   }   
    		   }
    		   boolean flagCompositeTask = true;// flag to check if all the subtasks are finished then change the status of the composite task to complete
    		   for(int index=0; index<subTasks.size(); index++){
    			   if(subTasks.get(index).getStatus().equals(TaskStatus.COMPLETED)){
    				   continue;
    			   }
    			   else{
    				   flagCompositeTask = false;
    				   break;
    			   }
    		   }
    		   if(flagCompositeTask == true){
    			   if(finalTask.getStatus() != (TaskStatus.COMPLETED)){
    				   String error ="Change the TaskStatus of Composite Task "+finalTask.getName()+ " to completed";
    				   throw new InvalidInput(error);
    			   }
    		   }// end of if
    		   finalTask.setVisited(true);
    	   }// end if visited check
       }// end of composite task check
    }// end of function

	public List<Task> getMainTasks() {
		return mainTasks;
	}
}