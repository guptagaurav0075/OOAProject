package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.ArrayList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Resource;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

//import java.util.*;

public class SimpleTask extends Task {
	private List<Resource> resources = new ArrayList<Resource>();

	public SimpleTask(String name, TaskStatus status, DateTime startDate, Duration duration,
			TaskDescription taskDescription, List<Resource> resources) {
		super(name, status, startDate, duration, taskDescription);
		this.resources = resources;
	}
	public SimpleTask(String name, DateTime startDate, Duration duration, List<Resource> resources) {
		super(name, startDate, duration);
		this.resources = resources;
	}
	public SimpleTask(String name, TaskStatus status, DateTime startDate, Duration duration, List<Resource> resources) {
		super(name, status, startDate, duration);
		this.resources = resources;
	}
	public SimpleTask(String name, DateTime startDate, Duration duration, TaskDescription taskDescription, List<Resource> resources) {
		super(name, startDate, duration, taskDescription);
		this.resources = resources;
	}
	public SimpleTask(String name, TaskStatus status, DateTime startDate, Duration duration,
			TaskDescription taskDescription) {
		super(name, status, startDate, duration, taskDescription);
	}
	public SimpleTask(String name, DateTime startDate, Duration duration) {
		super(name, startDate, duration);
	}
	public SimpleTask(String name, TaskStatus status, DateTime startDate, Duration duration) {
		super(name, status, startDate, duration);
		this.resources = resources;
	}
	public SimpleTask(String name, DateTime startDate, Duration duration, TaskDescription taskDescription) {
		super(name, startDate, duration, taskDescription);
	}

	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(Resource resources) {
		this.resources.add(resources);
	}
}