import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.travel.system.models.activities.Activity;

class ActivityTest {

    @Test
    void testCreateActivity() {
        Activity activity = Activity.createActivity("Hiking", "Mountain trail", 100.00, 20);
        assertNotNull(activity);
        assertEquals("Hiking", activity.getName());
        assertEquals("Mountain trail", activity.getDescription());
        assertEquals(100.00, activity.getCost());
        assertEquals(20, activity.getCapacity());
    }
}
