package org.travel.system.models.travelpackage;


import java.util.ArrayList;
import java.util.List;

import org.travel.system.models.activities.Activity;
import org.travel.system.models.destinations.Destination;
import org.travel.system.models.passengers.Passenger;

public class TravelPackage {
    private final String name;
    private final int passengerCapacity;
    private final List<Destination> destinations;
    private final List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println(" - Activity: " + activity.getName() + ", Cost: " + activity.getCost() + ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Package Name: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println(" - Name: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }

    public String getName(){
        return name;
    }

    public int getPassengerCapacity(){
        return passengerCapacity;
    }

    public List<Destination> getDestinations(){
        return destinations;
    }

    public List<Passenger> getPassengers(){
        return passengers;
    }
}

