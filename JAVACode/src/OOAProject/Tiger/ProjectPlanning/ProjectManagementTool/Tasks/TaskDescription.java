package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.*;

public class TaskDescription {
    public TaskDescription() {
    }
    private String description;
    private String additionalComments;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdditionalComments() {
		return additionalComments;
	}
	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}
}