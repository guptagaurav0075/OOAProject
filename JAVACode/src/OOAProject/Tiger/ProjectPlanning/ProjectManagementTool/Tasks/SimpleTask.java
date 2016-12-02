package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.ArrayList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Resource;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

//import java.util.*;

public class SimpleTask extends Task {
	private List<Resource> resources = new ArrayList<Resource>();
    public SimpleTask() {
    	super();
    }
    public DateTime getStartDate1(){
    	return super.getStartDate();
    }
    public String getName() {
		return super.getName();
	}
	public void setName(String name) {
		super.setName(name);
	}
	public TaskStatus getStatus() {
		return super.getStatus();
	}
	public void setStatus(TaskStatus status) {
		super.setStatus(status);
	}
	public DateTime getStartDate(){
		return super.getStartDate();
	}
	public void setStartDate(DateTime startDate) {
		super.setStartDate(startDate);
	}
	public DateTime getEndTime() {
		return super.getEndTime();
	}
	public void setEndTime(DateTime endTime) {
		super.setEndTime(endTime);
	}
	public List<Resource> getResources() {
		return getResources();
	}
	public void setResources(Resource resources) {
		this.resources.add(resources);
	}
	public Duration getDuration() {
		return super.getDuration();
	}
	public void setDuration(Duration duration) {
		super.setDuration(duration);
	}
	public TaskDescription getTaskDescription() {
		return super.getTaskDescription();
	}
	public void setTaskDescription(TaskDescription taskDescription) {
		super.setTaskDescription(taskDescription);
	}
	public List<Task> getPredecessor() {
		return super.getPredecessor();
	}
	public void setPredecessor(Task predecessor) {
		super.setPredecessor(predecessor);
	}
}