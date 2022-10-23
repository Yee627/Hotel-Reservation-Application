# Hotel Reservation Application
- Introduction
  This is a Java hotel reservation application from [Udacity Java Programming Course](link: https://www.udacity.com/course/java-programming-nanodegree--nd079). The hotel reservation application will allow customers to find and book a hotel room based on room availability. This project will be involved designing classes using OOP, organizing and processing data with collections, and using common Java types.
  
- Application Architecture
  - User interface (UI), including a main menu for the users who want to book a room, and an admin menu for administrative functions.
  - Resources will act as our Application Programming Interface (API) to our UI.
  - Services will communicate with our resources, and each other, to build the business logic necessary to provide feedback to our UI.
  - Data models will be used to represent the domain that we're using within the system (e.g., rooms, reservations, and customers).
  
- User Scenarios
  - Creating a customer account. The user needs to first create a customer account before they can create a reservation.
  - Searching for rooms. The app should allow the user to search for available rooms based on provided checkin and checkout dates. If the application has available rooms for the specified date range, a list of the corresponding rooms will be displayed to the user for choosing.
  - Booking a room. Once the user has chosen a room, the app will allow them to book the room and create a reservation.
  - Viewing reservations. After booking a room, the app allows customers to view a list of all their reservations.
  
- Admin Scenarios
  - Displaying all customers accounts.
  - Viewing all of the rooms in the hotel.
  - Viewing all of the hotel reservations.
  - Adding a room to the hotel application.
