# Hotel Reservation Application
- #####Introduction
  - This is a Java hotel reservation application from [Udacity Java Programming Course](https://www.udacity.com/course/java-programming-nanodegree--nd079). The hotel reservation application will allow customers to find and book a hotel room based on room availability. This project will be involved designing classes using OOP, organizing and processing data with collections, and using common Java types.
  
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

- Reservation Requirements
  - Avoid conflicting reservations. A single room may only be reserved by a single customer per a checkin and checkout date range.
  - Search for recommended rooms. If there are no available rooms for the customer's date range, a search will be performed that displays recommended rooms on alternative dates. The recommended room search will add seven days to the original checkin and checkout dates to see if the hotel has any availabilities, and then display the recommended rooms/dates to the customer.
  
  <sub> Example: If the customers date range search is 1/1/2020 – 1/5/2020 and all rooms are booked, the system will search again for recommended rooms using the date range 1/8/2020 - 1/12/2020. If there are no recommended rooms, the system will not return any rooms.</sub>

- Room Requirements
  - Room cost. Rooms will contain a price per night. When displaying rooms, paid rooms will display the price per night and free rooms will display "Free" or have a $0 price.
  - Unique room numbers. Each room will have a unique room number, meaning that no two rooms can have the same room number.
  - Room type. Rooms can be either single occupant or double occupant (Enumeration: SINGLE, DOUBLE).
  
- Customer Requirements
  - A unique email for the customer. RegEx is used to check that the email is in the correct format (i.e., name@domain.com).
  - A first name and last name.
  
  <sub> The email RegEx is simple for the purpose of this exercise and may not cover all real-world valid emails. For example "name@domain.co.uk" would not be accepted by the above RegEx because it does end with ".com". If you would like to try to make your RegEx more sophisticated, you may—but it is not required for this project.</sub>
  
- Error Requirements
  - No crashing. The application does not crash based on user input.
  - No unhandled exceptions. The app has try and catch blocks that are used to capture exceptions and provide useful information to the user. There are no unhandled exceptions.
