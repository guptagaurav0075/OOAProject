package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.ArrayList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Resource;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

//import java.util.*;

public class SimpleTask extends Task {
	private List<Resource> resources = new ArrayList<Resource>();

	public SimpleTask(String name, TaskStatus status, Duration duration,
			TaskDescription taskDescription, List<Resource> resources) {
		super(name, status, duration, taskDescription);
		this.resources = resources;
	}
	public SimpleTask(String name, Duration duration, List<Resource> resources) {
		super(name, duration);
		this.resources = resources;
	}
	public SimpleTask(String name, TaskStatus status,  Duration duration, List<Resource> resources) {
		super(name, status, duration);
		this.resources = resources;
	}
	public SimpleTask(String name, Duration duration, TaskDescription taskDescription, List<Resource> resources) {
		super(name,  duration, taskDescription);
		this.resources = resources;
	}
	public SimpleTask(String name, TaskStatus status, Duration duration,
			TaskDescription taskDescription) {
		super(name, status,duration, taskDescription);
	}
	public SimpleTask(String name, Duration duration) {
		super(name, duration);
	}
	public SimpleTask(String name, TaskStatus status, Duration duration) {
		super(name, status,  duration);
		this.resources = resources;
	}
	public SimpleTask(String name, Duration duration, TaskDescription taskDescription) {
		super(name, duration, taskDescription);
	}

	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(Resource resources) {
		this.resources.add(resources);
	}
	@Override
	public String toString() {
		return "Task [ Name: "+getName()+" Start Date :"+getStartDate()+" Task Status :"+ getStatus()+"]";
	}
}