package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;


import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Quantity.Quantity;

/**
 * 
 */
public class Material extends Resource {

    /**
     * Default constructor
     */
    public Material() {
    }

    private Quantity quantity;

	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}
    
    
}