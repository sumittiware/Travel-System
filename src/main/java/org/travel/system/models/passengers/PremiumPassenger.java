package org.travel.system.models.passengers;

import org.travel.system.models.activities.Activity;

public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = 0; // Balance is irrelevant for premium passengers so set 0
    }

    @Override
    public boolean enrollInActivity(Activity activity) {
        return activity.enrollPassenger();
    }
}
