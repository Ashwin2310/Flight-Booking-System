/*
* Creating 2 flights, for members and non members
*/
package coe528.lab1;

/**
 *
 * @author ashwi
 */
import java.util.*;

public class Manager {
    
    private static List<Flight> flights = new ArrayList<Flight>();
    private static List<Ticket> tickets = new ArrayList<Ticket>();
    private static int flightNumber = 1;
    
    public static String formatDepartureTime(int MM, int DD, int YYYY, int hour_24_format, int minute){
        return MM + "/" + DD + "/" + YYYY + " " + hour_24_format + ":" + minute;
    }
    public static void createFlights() {//using arrayList population
        flights.add(new Flight(flightNumber++, "Toronto", "Montreal", formatDepartureTime(02, 02, 2020, 8, 30), 100, 200));
        flights.add(new Flight(flightNumber++, "Alberta", "Calgary", formatDepartureTime(02, 03, 2020, 7, 50), 100, 400));
        flights.add(new Flight(flightNumber++, "Chicago", "Edmonton", formatDepartureTime(02, 01, 2020, 3, 20), 100, 500));
    }
    public static void displayAvailableFlights(String origin, String destination){
        for(Flight flyingFlights : flights){
            if(flyingFlights.getDestination().equals(destination) && flyingFlights.getOrigin().equals(origin))
                System.out.println(flyingFlights.toString());
        }
    }
    public static Flight getFlight(int FlightNumber){
        for(Flight temp : flights) {
            if (temp.getFlightNumber() == FlightNumber)
                return temp;
        }
        return (Flight)null;
    }
    
    public static boolean bookSeat(int flightNumber, Passenger passenger){
        Flight temp = getFlight(flightNumber);
        
        if(temp != null){
            if(temp.bookASeat()) {
                tickets.add(new Ticket(passenger, temp));
                return  true;
            }
            else
                return false;
        }
        return false;
    }
    public static void main(String[] args){
        
        //create all flight objects
        createFlights();
        //Display all flights
        displayAvailableFlights(flights.get(0).getOrigin(), flights.get(0).getDestination());
        displayAvailableFlights(flights.get(1).getOrigin(), flights.get(1).getDestination());
        displayAvailableFlights(flights.get(2).getOrigin(), flights.get(2).getDestination());
        
        
        for(int i = 0; i < flights.get(0).getCapacity(); i++){ //Book flight1 99/100 of memebers and non members
            if(i % 2 != 0)
                bookSeat(flights.get(0).getFlightNumber(), new Member (i%10, Integer.toString(i) , i%50));
            else
                bookSeat(flights.get(0).getFlightNumber(), new NonMember(Integer.toString(i), i%70));
        }
        
        for(int i = 0; i <= flights.get(1).getCapacity(); i++){ //Book flight2 100/100 of memebers and non members
            if(i % 2 != 0)
                bookSeat(flights.get(1).getFlightNumber(), new Member(i%10, Integer.toString(i) , i%50));
            else
                bookSeat(flights.get(1).getFlightNumber(), new NonMember(Integer.toString(i+100), i%70));
        }
        
        for(int i = 0; i <= flights.get(2).getCapacity() + 1; i++){ //Book flight1 101/100 of memebers and non members
            if(i % 2 != 0)
                bookSeat(flights.get(2).getFlightNumber(), new Member(i%10, Integer.toString(i) , i%50));
            else
                bookSeat(flights.get(2).getFlightNumber(), new NonMember(Integer.toString(i+200), i%70));
        }
        
        for(Ticket ticket : tickets){
            System.out.println(ticket);
        }
        
        //Test the Passenger Class
        Passenger passenger = new Member(5, "Gabe", 22);
        System.out.println("The passenger's name is : "+passenger.getName());
        System.out.println("The passenger's age is : "+passenger.getAge());
        
        passenger.setAge(90);
        passenger.setName("James");
        System.out.println("The passenger's name is : "+passenger.getName());
        System.out.println("The passenger's age is : "+passenger.getAge());
        
        //Test the ticket class
        Ticket ticket = new Ticket(passenger, flights.get(0)) ;
        System.out.println(ticket);
    }
}

