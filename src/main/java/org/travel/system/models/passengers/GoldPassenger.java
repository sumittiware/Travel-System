package org.travel.system.models.passengers;

import org.travel.system.models.activities.Activity;

public class GoldPassenger extends Passenger {
    public GoldPassenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
    }

    @Override
    public boolean enrollInActivity(Activity activity) {
        double cost = activity.getCost() * 0.9; // 10% discount
        if (this.balance >= cost && activity.enrollPassenger()) {
            this.balance -= cost;
            return true;
        }
        return false;
    }
}