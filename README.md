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
Groups:
 - Name: LoadEndpoints
    Method, Endpoint, Description:
      - [POST, /load, Create a new load]
      - [GET, /load, Get all loads]
      - [GET, /load/{id}, Get a load by ID]
      - [GET, /load?shipperId=x, Get loads by shipper ID]
      - [GET, /load?truckType=x, Get loads by truck type]
      - [PUT, /load/{id}, Update a load]
      - [DELETE, /load/{id}, Delete a load]

 - Name: BookingEndpoints
    Method, Endpoint, Description:
      - [POST, /booking, Create a booking]
      - [GET, /booking, Get all bookings]
      - [GET, /booking/{id}, Get a booking by ID]
      - [GET, /booking?transporterId=x, Get bookings by transporter ID]
      - [GET, /booking?loadId=x, Get bookings by load ID]
      - [PUT, /booking/{id}, Update a booking]
      - [DELETE, /booking/{id}, Delete a booking]
      - [PUT, /booking/accept/{id}, Accept a booking (status: ACCEPTED)]



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
