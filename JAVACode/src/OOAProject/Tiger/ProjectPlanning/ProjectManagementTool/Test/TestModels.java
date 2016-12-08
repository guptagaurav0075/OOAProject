package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Project;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Schedule;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Booking;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Equipment;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Labor;
import OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources.Material;
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
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Quantity.Quantity;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Quantity.Unit;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Telephone.PhoneNumberType;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Telephone.Telephone;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

public class TestModels {
	public static void main(String[]args) throws InvalidInput {
		
		// There are 5 tasks in our project - task1, task2, task3, task4, task5, task6
		// task1 is start task
		// task5 is final task
		// task 3 and task 4 are subtasks of composite task 6
		
		// set description of all tasks
		TaskDescription tD6 = new TaskDescription();
		tD6.setDescription("This is composite task containing task 3 and task 4 as subtasks");
		TaskDescription tD5 = new TaskDescription();
		tD5.setDescription("This is task 5 and this is the final task");
		TaskDescription tD4 = new TaskDescription();
		tD5.setDescription("This is task 4");
		TaskDescription tD3 = new TaskDescription();
		tD5.setDescription("This is task 3");
		TaskDescription tD2 = new TaskDescription();
		tD5.setDescription("This is task 2");
		TaskDescription tD1 = new TaskDescription();
		tD5.setDescription("This is task 1 and this is the start task");
		
		// set durations of all tasks
		Duration duration6 = new Duration(2);
		Duration duration5 = new Duration(1);
		Duration duration4 = new Duration(1);
		Duration duration3 = new Duration(1);
		Duration duration2 = new Duration(1);
		Duration duration1 = new Duration(1);
		
		// create all tasks
		CompositeTask ct = new CompositeTask("taskComposite", TaskStatus.NOT_STARTED, duration6, tD6);
		SimpleTask task5 = new SimpleTask("task5", TaskStatus.NOT_STARTED, duration5, tD5);
		SimpleTask task4 = new SimpleTask("task4", TaskStatus.NOT_STARTED, duration4, tD4);
		SimpleTask task3 = new SimpleTask("task3", TaskStatus.NOT_STARTED, duration3, tD3);
		SimpleTask task2 = new SimpleTask("task2", TaskStatus.NOT_STARTED, duration2, tD2);
		SimpleTask task1 = new SimpleTask("task1", TaskStatus.NOT_STARTED, duration1, tD1);
		
		// create startDates of all tasks
		DateTime startDate5 = new DateTime(12, 2016, 15);
		DateTime startDate4 = new DateTime(12, 2016, 13);
		DateTime startDate3 = new DateTime(12, 2016, 11);
		DateTime startDate2 = new DateTime(12, 2016, 9);
		DateTime startDate1 = new DateTime(12, 2016, 7);
		
		DateTime dob1 = new DateTime(12, 12, 12); // date of birth of labor1
		DateTime dob2 = new DateTime(12, 12, 12); // date of birth of labor2
		
		// set startDates of all tasks
		task5.setStartDate(startDate5);
		task4.setStartDate(startDate4);
		task3.setStartDate(startDate3);
		task2.setStartDate(startDate2);
		task1.setStartDate(startDate1);
		
		// add subtasks of composite task
		ct.addSubTask(task3);
		ct.addSubTask(task4);
		
		// set predecessors of task
		task5.setPredecessor(ct);
		ct.setPredecessor(task2);
		task2.setPredecessor(task1);
		
		
		// make bookings of resources
		Booking booking5 = new Booking(new DateTime(12, 2016, 14), new Duration(3));
		Booking booking4 = new Booking(new DateTime(12, 2016, 12), new Duration(3)); //
		Booking booking3 = new Booking(new DateTime(12, 2016, 13), new Duration(3)); // availability of labor2
		Booking booking2 = new Booking(new DateTime(12, 2016, 8), new Duration(5)); // availability of labor1
		Booking booking1 = new Booking(new DateTime(12, 2016, 6), new Duration(3)); // availability of truck
		
		//
		//
		
		Currency usd = new Currency("Dollar", "Cent", "USD", 100);
		Unit kilograms = new Unit("kilograms");
		Quantity quantityOfBricks = new Quantity(20, kilograms);
		
		Telephone telephoneNo = new Telephone("123", "3948948", PhoneNumberType.MOBILE);
		Address address1 = new Address("1", "33rd south", "San Jose", "California", "95112", "USA");
		Address address2 = new Address("5", "33rd south", "San Jose", "California", "95112", "USA");
		Email email1 = new Email("labor1", "gmail", "com");
		Email email2 = new Email("labor2", "gmail", "com");
		
		Person person1 = new Person("ABCD", "American", GenderType.MALE, address1, Title.MR, email1, dob1);
		Person person2 = new Person("AB", "American", GenderType.MALE, address2, Title.MR, email2, dob2);
		Money costOfTruck = new Money(45, 0, usd);
		Money costOfLabor = new Money(12, 0, usd);
		Money costOfCement = new Money(50, 0, usd);
		
		// create resources - labor, equipment and material
		Equipment truck = new Equipment("Truck", costOfTruck, booking1);
		Material cement = new Material("Bricks",costOfCement, quantityOfBricks);
		Labor labor1 = new Labor("labor1", costOfLabor, "001", person1, booking2);
		Labor labor2 = new Labor("labor1", costOfLabor, "002", person2, booking3);
		
		// make bookings
		
		truck.makeBooking(startDate1, duration1); // task1 has startDate - 7 December(duration is 1), and it needs truck which has availability from 6 to 9 December
		labor1.makeBooking(startDate2, duration2);// task2 has startDate - 9 December(duration is 1) and it needs labor1 which has availability from 8 to 13 December
		labor1.makeBooking(startDate3, duration3); // task3 has startDate - 11 December(duration is 1) and it needs labor1 which has availability from 8 to 13 December
		labor2.makeBooking(startDate4, duration4); // task4 has startDate - 13 December(duration is 1) and it needs labor2 which has availability from 13 to 16 December	
		labor2.makeBooking(startDate5, duration5); // task5 has startDate -15 December(duration is 1) and it needs labor2 which has availability from 13 to 16 December
		
		// create a new project
		Project myProject = new Project("House Building");
		myProject.addTask(task1);
		myProject.addTask(task2);
		myProject.addTask(task3);
		myProject.addTask(task4);
		myProject.addTask(task5);
		myProject.addTask(ct);
		
		Schedule schedule1 = new Schedule();
		myProject.GenerateSchedule(task5, startDate1);
		
	}
}
