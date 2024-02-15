package org.travel.system.models.passengers;

public abstract class Passenger implements Enrollable {
    protected String name;
    protected int passengerNumber;
    protected double balance;

    public double getBalance() {
        return balance;
    }

    public int getPassengerNumber(){
        return passengerNumber;
    }

    public String getName(){
        return name;
    }

    public static Passenger createPassenger(String type, String name, int passengerNumber, double balance) {
        switch (type.toLowerCase()) {
            case "standard":
                return new StandardPassenger(name, passengerNumber, balance);
            case "gold":
                return new GoldPassenger(name, passengerNumber, balance);
            case "premium":
                return new PremiumPassenger(name, passengerNumber);
            default:
                throw new IllegalArgumentException("Unknown passenger type: " + type);
        }
    }
}

