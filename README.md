# livesay_assignment
# Load & Booking Management System

> A RESTful backend system built with Spring Boot and Spring Data JPA for managing freight load postings and booking operations between shippers and transporters.

---

## Table of Contents
- [About](#about)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [License](#license)
- [Contact](#contact)
- [Validation & Error Handling](#validation-and-error-handling)

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
- RESTful API structure with validation
- UUID-based entity identification
- Enum-based status transitions for Load and Booking status
- Robust global exception handling with structured error responses
- Request DTOs for clean data separation and input validation
- Centralized validation error messages

---

## Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Lombok**
- **PostgreSQL**
- **Maven**

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
spring.datasource.url=jdbc:postgresql://localhost:5432/database-name
spring.datasource.username="username"
spring.datasource.password="password"
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
3. Build and run the application:
```bash
mvn spring-boot:run
```
## Validation and Error Handling

- All request bodies are validated using `jakarta.validation` annotations.
- Detailed error messages are returned for invalid input.
- Errors are wrapped in consistent JSON responses via a global exception handler.

**Example Validation Error Response:**

```json
{
  "timestamp": "2025-04-16T16:40:21.000",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "errors": {
    "transporterId": "Transporter ID is required",
    "proposedRate": "Proposed rate must be a positive number"
  }
}
```
## Usage
You can use Postman or cURL to test the endpoints.

Example:
```bash
curl -X POST http://localhost:8080/load \
-H "Content-Type: application/json" \
-d '{
  "shipperId": "SHIP123",
  "facility": {
    "loadingPoint": "Location A",
    "unloadingPoint": "Location B",
    "loadingDate": "2025-04-20T10:00:00",
    "unloadingDate": "2025-04-20T15:00:00"
  },
  "productType": "Electronics",
  "truckType": "Flatbed",
  "noOfTrucks": 2,
  "weight": 1500.5,
  "comment": "Handle with care",
  "datePosted": "2025-04-16T12:00:00",
  "status": "POSTED"
}

'
```
---
## API Endpoints
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

---
## License
This project is licensed under the MIT License - see the LICENSE file for details.
---
## Contact:
  - Jahnavi Sonayala
  - Email: jahnavi10282@gmail.com
  - https://www.linkedin.com/in/jahnavi-sonayala/
---
