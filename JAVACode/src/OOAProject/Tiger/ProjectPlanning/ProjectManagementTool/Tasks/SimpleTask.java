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

	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(Resource resources) {
		this.resources.add(resources);
	}
}