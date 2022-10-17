package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationService {
    private static ReservationService reservationService = null;

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    List<IRoom> rooms = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();

    public void addRoom(IRoom room){
        rooms.add(room);
    }

    public IRoom getARoom(String roomId){
        for (IRoom room: rooms) {
            if (room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public List<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        List<IRoom> availableRooms = new ArrayList<>();
        try {
            List<IRoom> reservedRooms = getReservedRooms(checkInDate, checkOutDate);
            for (IRoom room : rooms) {
                if (!reservedRooms.contains(room)) {
                    availableRooms.add(room);
                }
            }
        } catch (Exception e) {
            if (availableRooms.isEmpty()) return null;
        }
        return availableRooms;
    }

    public List<IRoom> getReservedRooms(Date checkInDate, Date checkOutDate) {
        List<IRoom> reservedRooms = new ArrayList<>();
        try {
            for (Reservation reservation : reservations) {
                if (reservation.getCheckInDate().getTime() <= checkInDate.getTime() && reservation.getCheckOutDate().getTime() >= checkOutDate.getTime()) {
                    reservedRooms.add(reservation.getRoom());
                }
            }
        } catch (Exception e) {
            if (reservedRooms.isEmpty()) return null;
        }
        return reservedRooms;
    }

    public void printAllReservation() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public List<Reservation> getCustomerReservation(String customerEmail) {
        List<Reservation> reservationsAccordingToCustomerEmail = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().getEmail().equals(customerEmail)) {
                reservationsAccordingToCustomerEmail.add(reservation);
            }
        }
        return reservationsAccordingToCustomerEmail;
    }

    public List<IRoom> getAllRooms() {
        return rooms;
    }

}
