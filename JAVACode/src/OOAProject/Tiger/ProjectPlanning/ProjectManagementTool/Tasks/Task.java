package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.List;


import java.util.ArrayList;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Resource;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;

public abstract class Task {

    public Task() {
    }
    private String name;
    private TaskStatus status =  TaskStatus.NOT_STARTED;
    private DateTime startDate;
    private DateTime endTime;
    private Duration duration;
    private TaskDescription taskDescription;
    private List<Task> predecessor = new ArrayList<Task>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public DateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	public DateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public TaskDescription getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(TaskDescription taskDescription) {
		this.taskDescription = taskDescription;
	}
	public List<Task> getPredecessor() {
		for(int index  = 0;index<predecessor.size();index++){
			Task temp = predecessor.get(index);
			if(temp.status == TaskStatus.COMPLETED){
				return null;
			}
			temp.status = TaskStatus.IN_PROGRESS;
			temp.getPredecessor();
			//System.out.println("Task ID :"+ temp.getTaskID()+ "\t Size : "+ temp.predecessorSize() );
		}
		//System.out.println("Task ID :"+predecessor.size()+");
		return predecessor;
	}
	public void setPredecessor(Task predecessor) {
		this.predecessor.add(predecessor);
	}
}