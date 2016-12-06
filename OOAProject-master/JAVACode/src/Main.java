import java.util.ArrayList;
import java.util.List;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Resource;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.CompositeTask;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.SimpleTask;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.TaskDescription;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Tasks.TaskStatus;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Refrences.Person;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Email;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.GenderType;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.InvalidInput;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Title;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Address.Address;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Currency;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Money;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Telephone.PhoneNumberType;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Telephone.Telephone;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

public class Main {

	public static void main(String[] args) {
			Telephone TP;
			try {
			
			//Testing Telephone,Address,Email,DateTime,Person
			TP = new Telephone("510","6480601",PhoneNumberType.MOBILE);
			Address AD = new Address("2","something","sanjose","california","46788","America");
			Email EID = new Email("Peter", "gmail","com");
			DateTime DOB =  new DateTime(12,2016,5);
			//System.out.println(DOB);
			DOB = DOB.add(new DateTime(0,0,1));
			//System.out.println(DOB);
			Person testperson = new Person("Peter","american",TP,GenderType.MALE,AD,Title.MR,EID,DOB);
			//System.out.println(testperson);
			
			//Testing Duration,TaskDescription,Currency,Money,Resources,SimpleTask
			Duration dur = new Duration(3);
			TaskDescription taskDescription = new TaskDescription();
			Currency cur = new Currency("dollar","cents","123",100);
			Money money = new Money(10,50,cur);
			List<Resource> myresource = new ArrayList<Resource>();
			SimpleTask ST = new SimpleTask("T1",TaskStatus.NOT_STARTED,dur,taskDescription,myresource);
			System.out.println(ST);
			
			//Testing CompositeTask
			CompositeTask CT = new CompositeTask("T2",TaskStatus.NOT_STARTED,dur,taskDescription);
			System.out.println(CT);
			
			
			} catch (InvalidInput e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
