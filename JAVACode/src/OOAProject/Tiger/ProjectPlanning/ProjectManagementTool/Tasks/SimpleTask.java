package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.ArrayList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Resource;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

//import java.util.*;

public class SimpleTask extends Task {
	
	public SimpleTask(String name){
		super(name);
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
	}
	public SimpleTask(String name, Duration duration, TaskDescription taskDescription) {
		super(name, duration, taskDescription);
	}

	
	@Override
	public String toString() {
		return "Task [ Name: "+getName()+" Start Date :"+getStartDate()+" Task Status :"+ getStatus()+"]";
	}
}