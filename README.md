# Travel Package Management System

The Travel Package Management System is a Java-based application designed to help travel agencies maintain travel packages, including itineraries, destinations, activities, and passenger lists. This system allows for dynamic creation and management of travel-related data, making it easier for agencies to offer customized travel packages to their clients.

## Features

- Create and manage **Travel Packages** with custom itineraries.
- Add **Destinations** and **Activities** to travel packages.
- Enroll **Passengers** in travel packages and specific activities with support for different passenger types (Standard, Gold, Premium).
- Print detailed itineraries and passenger lists for each travel package.
- Utilize a console-based interface for interaction with the system.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 11 or newer
- Maven

### Installing

1. Clone the repository to your local machine:
```bash
git clone https://github.com/sumittiware/Travel-System.git
```
2. Navigate to the project directory:
```bash
cd Travel-System
```
3. Use Maven to compile the project:
```bash
mvn compile
```
4. To package the application into a runnable JAR file with dependencies, use:
```bash
mvn package
```

### Running the Application

After compiling and packaging the application, you can run it using Java:
```bash
java -cp target/org.travel.system:Travel-System:jar:1.0-SNAPSHOT.jar org.travel.system.App
```

Replace `org.travel.system:Travel-System:jar:1.0-SNAPSHOT.jar` with the name of your packaged JAR file.

## Running the Tests
```bash
mvn test
```
This project uses JUnit for unit testing. To run the tests, use the following Maven command:

## Built With

- [Java](https://www.oracle.com/java/) - The programming language used
- [JUnit](https://junit.org/junit5/) - Friendly testing framework for Java and the JVM
- [Maven](https://maven.apache.org/) - Dependency Management

## Authors

- **Sumit Tiware** - [sumittiware](https://github.com/sumittiware)
