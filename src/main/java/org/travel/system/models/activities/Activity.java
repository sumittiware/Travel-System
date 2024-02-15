package org.travel.system.models.activities;


public class Activity {

    private final String name;
    private final String description;
    private final double cost;
    private final int capacity;
    private int enrolledPassengers;

    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.enrolledPassengers = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledPassengers() {
        return enrolledPassengers;
    }

    public int getAvailableSpaces() {
        return capacity - enrolledPassengers;
    }

    public boolean enrollPassenger() {
        if (enrolledPassengers < capacity) {
            enrolledPassengers++;
            return true;
        }
        return false;
    }

    public static Activity createActivity(String name, String description, double cost, int capacity) {
        return new Activity(name, description, cost, capacity);
    }
}
