package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;

import java.util.*;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
/**
 * 
 */
public abstract class SharableResource extends Resource {

    /**
     * Default constructor
     */
    public SharableResource() {
    }

    /**
     * @return
     */
    public Boolean isAvailable() {
        // TODO implement here
        return null;
    }

    /**
     * @param DateTime 
     * @param Duration 
     * @return
     */
    public Boolean makeBooking(DateTime StartDate, Duration duration) {
        // TODO implement here
        return null;
    }

    /**
     * @param DateTime 
     * @param Duration 
     * @return
     */
    public Boolean EditBooking(DateTime StartDate,  Duration duration) {
        // TODO implement here
        return null;
    }

}