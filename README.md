# livesay_assignment
# Load & Booking Management System

> A RESTful backend system built with Spring Boot and Spring Data JPA for managing freight load postings and booking operations between shippers and transporters.

---

## Table of Contents
- [About](#about)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [License](#license)
- [Contact](#contact)

---

## About

This project is a logistics-oriented application backend that handles:
- Shippers posting freight loads
- Transporters booking available loads
- Status management for loads and bookings

It uses Spring Boot for backend development and Spring Data JPA for database interactions.

---

## Features

- Create, read, update, delete (CRUD) for **Loads**
- Create and manage **Bookings**
- Manage **Load** and **Booking** statuses (`POSTED`, `BOOKED`, `CANCELLED`, etc.)
- RESTful API structure
- UUID-based entity identification
- Enum-based status transitions

---

## Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Lombok**
- **PostgreSQL**
- **Maven**

---

## Project Structure
src/
└── main/
    └── java/
        └── com/
            └── assignment/
                    ├── controller/
                    │   ├── LoadController.java
                    │   └── BookingController.java
                    ├── model/
                    │   ├── Load.java
                    |   ├── LoadStatus.java
                    │   ├── Booking.java
                    │   └── BookingStatus.java
                    │       
                    │        
                    ├── repository/
                    │   ├── LoadRepository.java
                    │   └── BookingRepository.java
                    └── service/
                        ├── LoadService.java
                        └── BookingService.java


---

## Installation

### Prerequisites
- Java 17+
- Maven
- PostgreSQL
- IDE (IntelliJ IDEA / Eclipse / VSCode)

### Steps

1. Clone the repository:
```bash
git clone https://github.com/jahnavi-soniyala/livesay_assignment.git
cd livesay_assignment
```
2. Update application.properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
3. Build and run the application:
```bash
mvn spring-boot:run
```
Usage
You can use Postman or cURL to test the endpoints.

Example:
```bash
curl -X POST http://localhost:8080/load \
-H "Content-Type: application/json" \
-d '{"shipperId": "SHIP123", "loadingPoint": "Delhi", "unloadingPoint": "Mumbai", ...}'
```
API Endpoints
Load Endpoints
load_endpoints:
  - method: POST
    endpoint: /load
    description: Create a new load

  - method: GET
    endpoint: /load
    description: Get all loads

  - method: GET
    endpoint: /load/{id}
    description: Get a load by ID

  - method: GET
    endpoint: /load?shipperId=x
    description: Get loads by shipper ID

  - method: GET
    endpoint: /load?truckType=x
    description: Get loads by truck type

  - method: PUT
    endpoint: /load/{id}
    description: Update a load

  - method: DELETE
    endpoint: /load/{id}
    description: Delete a load

booking_endpoints:
  - method: POST
    endpoint: /booking
    description: Create a booking

  - method: GET
    endpoint: /booking
    description: Get all bookings

  - method: GET
    endpoint: /booking/{id}
    description: Get a booking by ID

  - method: GET
    endpoint: /booking?transporterId=x
    description: Get bookings by transporter ID

  - method: GET
    endpoint: /booking?loadId=x
    description: Get bookings by load ID

  - method: PUT
    endpoint: /booking/{id}
    description: Update a booking

  - method: DELETE
    endpoint: /booking/{id}
    description: Delete a booking

  - method: PUT
    endpoint: /booking/accept/{id}
    description: Accept a booking (status: ACCEPTED)


License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact\n
Jahnavi Sonayala\n
https://www.linkedin.com/in/jahnavi-sonayala/ 
\nEmail: jahnavi10282gmail.com


---

Let me know if you want me to:
- Export this as a `README.md` file  
- Add badges (build, license, etc.)  
- Include example screenshots or Swagger integration  

Would you like me to generate the file for download?
