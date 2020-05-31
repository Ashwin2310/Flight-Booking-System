/*
Made by Ashwin Thomas on January 27.
Student number : 500877120
Objective (Lab 1) - To make a simple flight booking system where the user can book tickets for a certain trip. Based on whether they are a member or not, along with some other conditions, the final price along with the whole flight details is outputted onto the screen.
*/
package coe528.lab1;

/**
 *
 * @author ashwi
 */
public class Flight {
    //initializing 7 variables
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    public Flight (int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice){//6 constructors declared 
        try{
            if (origin.equals(destination))
                throw new IllegalArgumentException("Destination cannot be the same as origin");//Exception Handling when Destination and Origin are the same
            else{
                this.flightNumber = flightNumber;
                this.origin = origin;
                this.destination = destination;
                this.departureTime = departureTime;
                this.capacity = capacity;
                this.originalPrice = originalPrice;
            }//end else
        }//end try
        catch (IllegalArgumentException e){//Common Exception e 
            System.out.println (e);
        }//end catch
    }//end constructor
    
    public int getFlightNumber() {
        return flightNumber;
    }
    
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
   public void setDestination(String destination){
        try{
            if(!destination.equals(this.destination))
                this.destination = destination;
            else
                throw new IllegalArgumentException("Cannot be from the same origin and destination.");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
    public String getDepartureTime() {
        return departureTime;
    }
    
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
   /*not required - boolean setCapacity is created
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    */
    
    //setCapacity - keep track of seats 
    public boolean setCapacity (int capacity, boolean clearPlane){
        int totalSeats = numberOfSeatsLeft + (this.capacity - capacity);//the total seats can change based on listed capacity
        if (totalSeats > 0 && clearPlane == false){
            numberOfSeatsLeft = totalSeats;
            this.capacity = capacity;
            return false;
        }
        else{
            this.capacity = capacity;
            numberOfSeatsLeft = capacity;
            return true;
        }   
    }
    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }
    
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    public double getOriginalPrice() {
        return originalPrice;
    }   
    
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    public boolean bookASeat(){//checking if seats are available to book a seat
        if (numberOfSeatsLeft > 0)//check if it is not empty
        {
            numberOfSeatsLeft -= 1;
            return true;
        }
        return false;
    }//end bookASeat 
    
    //Main to String method 
    @Override
    public String toString (){
        return "Flight Number:" +this.flightNumber + ", From " + this.origin + " to " + this.destination + ", on " + this.departureTime + ", Original Price: "+ this.originalPrice;
        
    }//end toString()
}//end Flight class
