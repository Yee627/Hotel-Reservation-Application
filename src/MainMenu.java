import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static HotelResource hotelResource = HotelResource.getInstance();
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        try {
            boolean exit = false;
            while (!exit) {
                String selection = showMenu();
                switch (selection) {
                    case "1" -> findAndReserveRoom();
                    case "2" -> seeMyReservation();
                    case "3" -> createAccount();
                    case "4" -> AdminMenu.startAdmin();
                    case "5" -> exit = true;
                    default -> showMenu();
                }
            }
            System.exit(0);
        } catch(Exception ex){
            ex.getLocalizedMessage();
        } finally{
            scanner.close();
        }
    }

    private static String showMenu() {
        System.out.println("__________________________________________________");
        System.out.println("MAIN MENU");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservation");
        System.out.println("3. Create an Account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("__________________________________________________");
        System.out.println("Enter menu");
        return scanner.nextLine();
    }

    private static void findAndReserveRoom() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Enter CheckIn Date dd/mm/yyyy example (25/08/2022");
        Date checkInDate = dateFormat.parse(scanner.nextLine());
        System.out.println("Enter CheckOut Date dd/mm/yyyy example (28/08/2022");
        Date checkOutDate = dateFormat.parse(scanner.nextLine());
        List<IRoom> availableRooms = hotelResource.findARoom(checkInDate,checkOutDate);

        if (!availableRooms.isEmpty()) {
            Customer customer;

            System.out.println("Would you like to book a room? y/n");
            char optionBookARoom = scanner.next().trim().charAt(0);

            if (optionBookARoom == 'y') {
                System.out.println("Do you have an account with us? y/n");
                char optionHasAccount = scanner.next().trim().charAt(0);

                if (optionHasAccount == 'y') {
                    customer = getExistingAccount();

                    if (customer == null) {
                        System.out.println("Customer was not found.");
                        return;
                    }
                } else {
                    customer = createAccount();
                }

                boolean isRoomAvailable = false;
                while (!isRoomAvailable) {
                    System.out.println("Available rooms: ");
                    System.out.println(availableRooms);
                    System.out.println("Please enter room number from the available rooms:");
                    String roomNumber = scanner.next();
                    IRoom selectedRoom = hotelResource.getRoom(roomNumber);

                    if (!availableRooms.contains(selectedRoom)) {
                        System.out.println("Sorry, room number " + roomNumber + " is not available.");
                    } else {
                        hotelResource.bookARoom(customer, selectedRoom, checkInDate,checkOutDate);
                        System.out.println("Reservation was successfully created!");
                        scanner.nextLine();
                        isRoomAvailable = true;
                    }
                }
            }
        } else {
            System.out.println("Sorry there is no room available. ");
        }
    }

    private static Customer getExistingAccount() {
        System.out.println("Enter Email format: name@domain.com");
        String email = scanner.next();

        return hotelResource.getCustomer(email);
    }

    private static Customer createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Customer Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter Customer Email format: name@domain.com :");
        String email = scanner.nextLine();

        try {
            hotelResource.createACustomer(email, firstName, lastName);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return new Customer(firstName, lastName, email);
    }

    private static void seeMyReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Email format: name@domain.com");
        String email = scanner.next();
        System.out.println(hotelResource.getCustomersReservations(email));
    }

}
