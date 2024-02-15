package org.travel.system.models.passengers;

import org.travel.system.models.activities.Activity;

public interface Enrollable {
    boolean enrollInActivity(Activity activity);
}
