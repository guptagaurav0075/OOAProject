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
     */
	public CompositeTask(String name, TaskStatus status, DateTime startDate, Duration duration,
			TaskDescription taskDescription) {
		super(name, status, startDate, duration, taskDescription);
	}
	public CompositeTask(String name, DateTime startDate, Duration duration) {
		super(name, startDate, duration);
	}
	public CompositeTask(String name, TaskStatus status, DateTime startDate, Duration duration) {
		super(name, status, startDate, duration);
	}
	public CompositeTask(String name, DateTime startDate, Duration duration, TaskDescription taskDescription) {
		super(name, startDate, duration, taskDescription);
	}    /**
     * 
     */
    private List<Task> subtasks = new ArrayList<Task>();
	public List<Task> getSubtasks() {
		return subtasks;
	}
	public void setSubtasks(Task subtask) {
		subtasks.add(subtask);
	}
    

}