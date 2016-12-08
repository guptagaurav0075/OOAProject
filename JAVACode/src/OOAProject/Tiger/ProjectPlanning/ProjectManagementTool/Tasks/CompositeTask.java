package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.ArrayList;
import java.util.List;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;


/**
 * 
 */
public class CompositeTask extends Task {

    /**
     * Default constructor
     * 
     */
	public CompositeTask(String name){
		super(name);
	}
	public CompositeTask(String name, TaskStatus status, Duration duration,
			TaskDescription taskDescription) {
		super(name, status,  duration, taskDescription);
	}
	public CompositeTask(String name, Duration duration) {
		super(name, duration);
	}
	public CompositeTask(String name, TaskStatus status, Duration duration) {
		super(name, status, duration);
	}
	public CompositeTask(String name, Duration duration, TaskDescription taskDescription) {
		super(name,  duration, taskDescription);
	}    /**
     * 
     */
    private List<Task> subtasks = new ArrayList<Task>();
	public List<Task> getSubtasks() {
		return subtasks;
	}
	
	public void addSubTask(Task subTask){
		subtasks.add(subTask);
	}

}