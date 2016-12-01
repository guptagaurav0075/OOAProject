package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.*;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Resource;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
/**
 * 
 */
public abstract class Task {

    public Task() {
    }
    private String name;
    private TaskStatus status;
    private DateTime startDate;
    private DateTime endTime;
    private Set<Resource> resources;
    private Duration duration;
    private TaskDescription taskDescription;
    private Task predecessor;
    
}