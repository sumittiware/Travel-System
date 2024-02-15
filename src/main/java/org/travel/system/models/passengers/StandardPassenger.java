package org.travel.system.models.passengers;

import org.travel.system.models.activities.Activity;

public class StandardPassenger extends Passenger {
    public StandardPassenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
    }

    @Override
    public boolean enrollInActivity(Activity activity) {
        double cost = activity.getCost();
        if (this.balance >= cost && activity.enrollPassenger()) {
            this.balance -= cost;
            return true;
        }
        return false;
    }
}