# Gym Management API

## Overview
The Gym Management API is a Spring Boot application designed to manage gym classes and bookings for a gym or workout club. It provides RESTful APIs for:
- Creating classes for the gym.
- Booking a member into a class.
- Searching for bookings by member name or date range.

This project uses **Spring Boot**, **H2 Database**, and follows **RESTful API standards**.

---

## Features
1. **Create Classes**: 
   - Define a class with details like name, start date, end date, time, duration, and capacity.
   - Ensure business rules, such as capacity and future dates, are validated.

2. **Book a Class**:
   - Book a spot in a class for a member.
   - Ensure capacity constraints are followed and participation dates are valid.

3. **Search Bookings**:
   - Search for bookings by member name, date range, or both.

---

## Technologies Used
- **H2 Database** (in-memory for testing)
- **Spring Data JPA** (for database interaction)
- **Spring Web** (for RESTful APIs)
- **Spring Boot Validation** (for input validation)

---
