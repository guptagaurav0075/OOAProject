package OOAProject.Tiger.ProjectPlanning.ProjectManagementTool.Resources;

import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Duration;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Currency;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Money.Money;
import OOAProject.Tiger.ProjectPlanning.ReusableBusinessClasses.Values.Time.DateTime;

import java.util.LinkedList;

public class TestingResource {

    public static void main(String[] args){

        try {
            DateTime startDate1 = new DateTime(6, 2016, 4);
            Duration duration1 = new Duration(12,1,0);
            Booking booking1 = new Booking(startDate1, duration1);

            Currency usd = new Currency("Dollar", "Cent", "USD", 100);
            Money costOfTruck = new Money(45, 0, usd);
            Equipment truck = new Equipment("Truck", costOfTruck);

            truck.makeBooking(new DateTime(7,2016,4), new Duration(0,1,0));
            truck.makeBooking(new DateTime(7,2015,4), new Duration(0,1,0));

//            for(Booking bo	oking : myTruckBookings){
//                System.out.println(booking);
//            }
            System.out.println("Bookings :"+ truck.getBookings().size());
            for(int index=0; index<truck.getBookings().size(); index++){
            	System.out.println(truck.getBookings().get(index));
            }

        } catch (Exception E){
            //E.printStackTrace();
        }
    }



}
