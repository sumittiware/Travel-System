package org.travel.system.models.destinations;

import java.util.ArrayList;
import java.util.List;

import org.travel.system.models.activities.Activity;

public class Destination {
    private final String name;
    private final List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    // Add an activity to the destination
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public static Destination createDestination(String name) {
        return new Destination(name);
    }
}

