import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.travel.system.models.activities.Activity;
import org.travel.system.models.destinations.Destination;

class DestinationTest {

    @Test
    void testCreateDestination() {
        Destination destination = new Destination("Paris");
        assertNotNull(destination);
        assertEquals("Paris", destination.getName());
    }

    @Test
    void testAddActivity() {
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Eiffel Tower Tour", "A tour of the Eiffel Tower", 50.0, 10);
        destination.addActivity(activity);

        assertNotNull(destination.getActivities());
        assertFalse(destination.getActivities().isEmpty());
        assertEquals(1, destination.getActivities().size());
        assertEquals("Eiffel Tower Tour", destination.getActivities().get(0).getName());
    }
}
