package org.travel.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.travel.system.models.activities.Activity;
import org.travel.system.models.destinations.Destination;
import org.travel.system.models.passengers.Passenger;
import org.travel.system.models.travelpackage.TravelPackage;
import org.travel.system.utils.MenuOptions;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Activity> activities = new ArrayList<>();
    private static final List<Destination> destinations = new ArrayList<>();
    private static final List<TravelPackage> travelPackages = new ArrayList<>();
    private static final List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {

            final int choice = showMenu();

            switch (choice) {
                case MenuOptions.CREATE_ACTIVITY:
                    createActivity();
                    break;
                case MenuOptions.CREATE_DESTINATION:
                    createDestination();
                    break;
                case MenuOptions.ADD_ACTIVITY_TO_DESTINATION:
                    addActivityToDestination();
                    break;
                case MenuOptions.CREATE_TRAVEL_PACKAGE:
                    createTravelPackage();
                    break;
                case MenuOptions.ADD_DESTINATION_TO_PACKAGE:
                    addDestinationToPackage();
                    break;
                case MenuOptions.CREATE_PASSENGER:
                    createPassenger();
                    break;
                case MenuOptions.ADD_PASSENGER_TO_PACKAGE:
                    addPassengerToPackage();
                    break;
                case MenuOptions.EXIT:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static int showMenu() {
        System.out.println("\nWelcome to the Travel Package Management System");
        System.out.println("1. Create an Activity");
        System.out.println("2. Create a Destination");
        System.out.println("3. Add activity to Destination");
        System.out.println("4. Create a Travel Package");
        System.out.println("5. Add destinations to Travel Package");
        System.out.println("6. Create a Passenger");
        System.out.println("7. Add Passenger to a Travel Package");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    private static void createActivity() {
        System.out.println("\nPlease enter activity details");

        System.out.println("1. Activity Name : ");
        final String name = scanner.nextLine();
        System.out.println("2. Activity Description : ");
        final String description = scanner.nextLine();
        System.out.println("3. Activity Cost : ");
        final double cost = scanner.nextDouble();
        System.out.println("4. Activity Capacity : ");
        final int capacity = scanner.nextInt();
        scanner.nextLine();

        final Activity newActivity = Activity.createActivity(name, description, cost, capacity);

        activities.add(newActivity);
        System.out.println("\nActivity Added!");
    }

    private static void createDestination() {
        System.out.println("\nPlease enter destination details:");
        System.out.println("Destination Name: ");
        final String name = scanner.nextLine();
        final Destination newDestination = Destination.createDestination(name);

        destinations.add(newDestination);
        System.out.println("\nDestination Added!");
    }

    private static void addActivityToDestination() {
        if(destinations.isEmpty()) {
            System.out.println("No Destinations available. Please create some!");
            return;
        }
        System.out.println("Please select the Destination : ");
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println((i + 1) + ". " + destinations.get(i).getName());
        }
        int destinationChoice = scanner.nextInt() - 1;
        final Destination destination = destinations.get(destinationChoice);
        addActivity(destination);
    }

    private static void addActivity(Destination destination) {
        if(activities.isEmpty()){
            System.out.println("No activities available. Please create some!");
            return;
        }

        System.out.println("Available Activities:");
        for (int i = 0; i < activities.size(); i++) {
            System.out.println((i + 1) + ". " + activities.get(i).getName());
        }
        System.out.println("Select an activity number to add to the destination, or 0 to skip:");
        int activityChoice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (activityChoice >= 0 && activityChoice < activities.size()) {
            destination.addActivity(activities.get(activityChoice));
            System.out.println("Activity added to the destination.");
        } else {
            System.out.println("No activity added.");
        }
    }

    private static void createTravelPackage() {
        System.out.println("\nPlease enter travel package details:");
        System.out.println("Travel Package Name: ");
        final String packageName = scanner.nextLine();
        System.out.println("Passenger Capacity: ");
        final int capacity = scanner.nextInt();
        scanner.nextLine();

        final TravelPackage newPackage = new TravelPackage(packageName, capacity);

        travelPackages.add(newPackage);
        System.out.println("\nTravel Package Added!");
    }

    private static void addDestinationToPackage() {
        if(travelPackages.isEmpty()) {
            System.out.println("No Travel Packages available. Please create some!");
            return;
        }
        System.out.println("Please select the Travel Package : ");
        for (int i = 0; i < travelPackages.size(); i++) {
            System.out.println((i + 1) + ". " + travelPackages.get(i).getName());
        }
        int travelPackageChoice = scanner.nextInt() - 1;
        final TravelPackage travelPackage = travelPackages.get(travelPackageChoice);
        addDestination(travelPackage);
    }

    private static void addDestination(TravelPackage travelPackage) {
        if(destinations.isEmpty()) {
            System.out.println("No Destinations available. Please create some!");
            return;
        }
        System.out.println("Available Destinations:");
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println((i + 1) + ". " + destinations.get(i).getName());
        }
        System.out.println("Select a destination number to add to the package, or 0 to skip:");
        int destinationChoice = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (destinationChoice >= 0 && destinationChoice < destinations.size()) {
            travelPackage.addDestination(destinations.get(destinationChoice));
            System.out.println("Destination added to the package.");
        } else {
            System.out.println("No destination added.");
        }
    }

    private static void createPassenger() {
        System.out.println("\nPlease enter passenger details:");
        System.out.println("Passenger Type (standard/gold/premium): ");
        final String type = scanner.nextLine();
        System.out.println("Passenger Name: ");
        final String name = scanner.nextLine();
        System.out.println("Passenger Number: ");
        final int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        double balance = 0.0;
        if (!"premium".equalsIgnoreCase(type)) {
            System.out.println("Passenger Balance: ");
            balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
        }

        final Passenger newPassenger = Passenger.createPassenger(type, name, number, balance);
        passengers.add(newPassenger);
        System.out.println("\nNew Passenger Added!");
    }

    private static void addPassengerToPackage() {
        if (travelPackages.isEmpty()) {
            System.out.println("No travel packages available.");
            return;
        }

        System.out.println("Select a travel package:");
        for (int i = 0; i < travelPackages.size(); i++) {
            System.out.println((i + 1) + ". " + travelPackages.get(i).getName());
        }
        int packageChoice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (packageChoice >= 0 && packageChoice < travelPackages.size()) {
            TravelPackage selectedPackage = travelPackages.get(packageChoice);

            System.out.println("Available Passengers:");
            for (int i = 0; i < passengers.size(); i++) {
                System.out.println((i + 1) + ". " + passengers.get(i).getName());
            }
            System.out.println("Select a passenger number to add to the package, or 0 to skip:");
            int passengerChoice = scanner.nextInt() - 1;
            scanner.nextLine();

            if (passengerChoice >= 0 && passengerChoice < passengers.size()) {
                if (selectedPackage.addPassenger(passengers.get(passengerChoice))) {
                    System.out.println("Passenger added to the package.");
                } else {
                    System.out.println("Failed to add passenger. Package might be full.");
                }
            } else {
                System.out.println("No passenger added.");
            }
        } else {
            System.out.println("Invalid package selection.");
        }
    }

}
