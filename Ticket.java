/*
 * To change this license header, choose License Headers in Project Properties.
Made by Ashwin Thomas on January 27. 
Student number : 500877120
Objective (Lab 1) - To make a simple flight booking system where the user can book tickets for a certain trip. Based on whether they are a member or not, along with some other conditions, the final price along with the whole flight details is outputted onto the screen.
 */
package coe528.lab1;

/**
 *
 * @author ashwi
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private static int ticketNumber = 1;//required static variable 
    private double price;
    private int number;
    
    public Ticket (Passenger p, Flight flight, double price)
    {
        this.passenger = passenger;
        this.flight = flight;
        this.price = passenger.applyDiscount (flight.getOriginalPrice());
        this.number = ticketNumber ++;
    
    }//end Ticket
   
 public Ticket(Passenger passenger, Flight flight){
        this.passenger = passenger;
        this.flight = flight;
        this.price = passenger.applyDiscount(flight.getOriginalPrice());
        this.number = ticketNumber++;
    }

    /**
     *
     * @param ticket
     */
    public Ticket(Ticket ticket){
        this.passenger = ticket.getPassenger();
        this.flight = ticket.getFlight();
        this.price = ticket.getPrice();
        this.number = ticket.getTicketNumber();
    }
    
    //to String method
   @Override
   public String toString (){
       return "Passenger Name : "+passenger.getName()+ ", "+flight.toString ()+ ", Ticket Price : $"+ price;
   }//end toString

   //Getter and Setter methods
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

 
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public static int getTicketNumber() {
        return ticketNumber;
    }

    public static void setTicketNumber(int ticketNumber) {
        Ticket.ticketNumber = ticketNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}//end ticket class