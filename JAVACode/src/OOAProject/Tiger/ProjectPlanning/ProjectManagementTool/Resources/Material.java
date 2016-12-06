package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;


import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Money;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Quantity.Quantity;

/**
 * 
 */
public class Material extends Resource {

    private Quantity quantity;

	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}


	public Material(String name, Money cost, Quantity quantity) {
		super(name, cost);
		// TODO Auto-generated constructor stub
		this.quantity = quantity;
	}
    
    
}