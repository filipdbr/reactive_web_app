# Reactive Web App

This project demonstrates a **reactive web application** using **Spring Boot** and **WebFlux**. It’s designed with two services: a **Trigger Service** that initiates tasks and a **Receiver Service** that processes those tasks asynchronously. The app leverages non-blocking, reactive streams to perform actions while efficiently managing resources.

While originally planned for **Java 11**, this project is built with **Java 17** (using **JDK 21**). Everything works smoothly on this setup, but keep that in mind when running or deploying it.

## Project Structure

The project is organized as a multi-module Maven application:

```bash
reactive_web_app/
├── pom.xml (Parent POM for both services)
├── trigger_service/
│   ├── src/
│   └── pom.xml (for trigger_service)
├── receiver_service/
│   ├── src/
│   └── pom.xml (for receiver_service)
```

- **Trigger Service** (`trigger_service/`): Sends an HTTP request to the **Receiver Service** to initiate a counting task.
- **Receiver Service** (`receiver_service/`): Responds to the **Trigger Service** by counting from 0 to 1000, with a 1-second delay between each number.

## Technologies Used

- **Java 17** with **JDK 21**
- **Spring Boot** with **WebFlux** for reactive, non-blocking web handling
- **Maven** for dependency management and project structure
- **Reactor** for handling reactive streams
- **WebClient** for asynchronous HTTP calls between services

## How to Run the Project

1. **Clone the repository**:
```bash
git clone <your-repo-url>
```

2. **Build the project using Maven**
```bash
mvn clean install
```
3. **Run the Receiver Service**
   
    
Navigate to the `receiver_service` directory and run:
```bash
mvn spring-boot:run
```
This will start the Receiver Service on port 8081.


4. **Run the Trigger Service**

Navigate to the `trigger_service` directory and run:
```bash
mvn spring-boot:run
```
The Trigger Service will send an HTTP request to the Receiver Service on port 8081 and initiate the task.

## What happens:
- The **Trigger Service** calls the **Receiver Service**, which starts counting from 0 to 1000, printing each number with a 1-second delay.
- Once the counting is complete, the **Receiver Service** returns a message saying "task completed", which is logged by the **Trigger Service**.

## Notes on Java Version

This project was initially planned for **Java 11**, but it was developed using **Java 17** with **JDK 21**. Please ensure you have the correct Java version installed before running the project.

## Project Structure Breakdown

Here’s a quick overview of the directories:

- **`pom.xml`** (in the root): Parent POM that manages both **trigger_service** and **receiver_service** modules.

- **trigger_service/**:
    - Contains the **Trigger Service**, responsible for initiating the counting task.
    - Key files:
        - `TriggerServiceApplication.java`: Main application file, which sends the HTTP request to the **Receiver Service**.
        - `application.properties`: Configures the **Trigger Service** to run on **port 8082**.

- **receiver_service/**:
    - Contains the **Receiver Service**, responsible for handling the counting task.
    - Key files:
        - `ReceiverServiceApplication.java`: Main application file, which handles the counting logic and returns the result.
        - `application.properties`: Configures the **Receiver Service** to run on **port 8081**.


