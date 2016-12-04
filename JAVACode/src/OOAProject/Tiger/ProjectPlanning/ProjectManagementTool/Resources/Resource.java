package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Money;
/**
 * 
 */
public abstract class Resource {

    public Resource(String name, Money cost) {
		this.name = name;
		this.cost = cost;
	}
	private String name;
    private Money cost;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Money getCost() {
		return cost;
	}
	public void setCost(Money cost) {
		this.cost = cost;
	}
}