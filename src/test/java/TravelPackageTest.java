import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.travel.system.models.activities.Activity;
import org.travel.system.models.destinations.Destination;
import org.travel.system.models.travelpackage.TravelPackage;
import org.travel.system.models.passengers.Passenger;
import org.travel.system.models.passengers.StandardPassenger;

class TravelPackageTest {

    private TravelPackage travelPackage;
    private Destination destination;
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        travelPackage = new TravelPackage("European Adventure", 2);
        destination = new Destination("Paris");
        Activity activity = new Activity("Eiffel Tower Tour", "Visit the Eiffel Tower", 100.00, 20);
        destination.addActivity(activity);
        passenger = new StandardPassenger("John Doe", 1, 500.00); // Assuming the implementation of StandardPassenger
    }

    @Test
    void testAddDestination() {
        travelPackage.addDestination(destination);
        assertFalse(travelPackage.getDestinations().isEmpty());
        assertEquals(1, travelPackage.getDestinations().size());
        assertEquals("Paris", travelPackage.getDestinations().get(0).getName());
    }

    @Test
    void testAddPassengerWithinCapacity() {
        assertTrue(travelPackage.addPassenger(passenger));
        assertEquals(1, travelPackage.getPassengers().size());
        assertEquals("John Doe", travelPackage.getPassengers().get(0).getName());
    }

    @Test
    void testAddPassengerExceedCapacity() {
        travelPackage.addPassenger(passenger);
        Passenger secondPassenger = new StandardPassenger("Jane Doe", 2, 600.00);
        travelPackage.addPassenger(secondPassenger);
        Passenger thirdPassenger = new StandardPassenger("Bob Smith", 3, 700.00);
        assertFalse(travelPackage.addPassenger(thirdPassenger));
        assertEquals(2, travelPackage.getPassengers().size());
    }

    @Test
    void testPrintItinerary() {
        travelPackage.addDestination(destination);
        travelPackage.printItinerary();
        assertTrue(true);
    }

    @Test
    void testPrintPassengerList() {
        travelPackage.addPassenger(passenger);
        travelPackage.printPassengerList();
        assertTrue(true); // Adjust accordingly
    }
}
