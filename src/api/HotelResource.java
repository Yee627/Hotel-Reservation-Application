package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class HotelResource {
    private static HotelResource hotelResource = null;

    private HotelResource() {
    }

    public static HotelResource getInstance() {
        if (hotelResource == null) {
            hotelResource = new HotelResource();
        }
        return hotelResource;
    }

    CustomerService customerService = CustomerService.getInstance();
    ReservationService reservationService = ReservationService.getInstance();

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(firstName, lastName, email);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }


    public Reservation bookARoom(Customer customer, IRoom room, Date checkInDate, Date CheckOutDate) {
        return reservationService.reserveARoom(customer, room, checkInDate, CheckOutDate);
    }


    public List<Reservation> getCustomersReservations(String customerEmail) {
        return reservationService.getCustomerReservation(customerEmail);
    }

    public List<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }
}
