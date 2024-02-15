import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.travel.system.models.activities.Activity;
import org.travel.system.models.passengers.*;

class PassengerTest {

    private Activity activity;

    @BeforeEach
    void setUp() {
        activity = new Activity("City Tour", "Tour around the city", 100.00, 10);
    }

    @Test
    void testCreateStandardPassenger() {
        Passenger passenger = Passenger.createPassenger("standard", "John Doe", 1, 200.00);
        assertInstanceOf(StandardPassenger.class, passenger);
        assertEquals(200.00, passenger.getBalance());
    }

    @Test
    void testCreateGoldPassenger() {
        Passenger passenger = Passenger.createPassenger("gold", "Jane Doe", 2, 300.00);
        assertInstanceOf(GoldPassenger.class, passenger);
        assertEquals(300.00, passenger.getBalance());
    }

    @Test
    void testCreatePremiumPassenger() {
        Passenger passenger = Passenger.createPassenger("premium", "Alex Smith", 3, 0);
        assertInstanceOf(PremiumPassenger.class, passenger);
        assertEquals(0, passenger.getBalance());
    }

    @Test
    void testStandardPassengerEnrollInActivity() {
        StandardPassenger passenger = new StandardPassenger("John Doe", 1, 200.00);
        assertTrue(passenger.enrollInActivity(activity));
        assertEquals(100.00, passenger.getBalance());
    }

    @Test
    void testGoldPassengerEnrollInActivityWithDiscount() {
        GoldPassenger passenger = new GoldPassenger("Jane Doe", 2, 300.00);
        assertTrue(passenger.enrollInActivity(activity));
        assertEquals(210.00, passenger.getBalance(), "Balance after enrollment should reflect the discount.");
    }

    @Test
    void testPremiumPassengerEnrollInActivityForFree() {
        PremiumPassenger passenger = new PremiumPassenger("Alex Smith", 3);
        assertTrue(passenger.enrollInActivity(activity));
        assertEquals(0, passenger.getBalance(), "Premium passenger should not be charged for activities.");
    }

    @Test
    void testEnrollmentFailsWhenActivityIsFull() {
        Activity fullActivity = new Activity("Full Tour", "This tour is full", 50.00, 0); // 0 capacity
        StandardPassenger passenger = new StandardPassenger("John Doe", 1, 200.00);

        assertFalse(passenger.enrollInActivity(fullActivity));
    }

    @Test
    void testEnrollmentFailsWhenInsufficientBalance() {
        StandardPassenger passenger = new StandardPassenger("John Doe", 1, 50.00); // Not enough for the activity
        assertFalse(passenger.enrollInActivity(activity));
    }
}
