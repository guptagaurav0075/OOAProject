package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks;

import java.util.*;

public class TaskDescription {
    public TaskDescription() {
    }
    private String Description;
    private String AdditionalComments;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAdditionalComments() {
		return AdditionalComments;
	}
	public void setAdditionalComments(String additionalComments) {
		AdditionalComments = additionalComments;
	}
}