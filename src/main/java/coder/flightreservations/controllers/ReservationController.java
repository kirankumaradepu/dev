package coder.flightreservations.controllers;

import coder.flightreservations.models.Reservation;
import coder.flightreservations.models.Seats;
import coder.flightreservations.repository.ReservationRepository;
import coder.flightreservations.repository.ValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    private ReservationRepository repository;
    private ValuesRepository valuesRepository;

    @Autowired
    public ReservationController(ReservationRepository repository, ValuesRepository valuesRepository) {
        this.repository = repository;
        this.valuesRepository = valuesRepository;
    }

    //this method is used to Get All Reservations
    @RequestMapping(value = "/getReservations", method = RequestMethod.GET)
    public List<Reservation> getReservations() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //this method is used to Get All Reservations
    @RequestMapping(value = "/validateReservations/{id}", method = RequestMethod.GET)
    public Optional<Reservation> getReservations(@PathVariable("id") Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //this method is used to getSeats options for ticketClass
    @RequestMapping(value = "/getSeats/{ticketType}", method = RequestMethod.GET)
    public List<Seats> getSeats(@PathVariable("ticketType") Integer ticketType) {
        try {
            return valuesRepository.findByTicketType(ticketType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Updates the SeatNo for selected reservation
    @RequestMapping(value = "/updateReservation", method = RequestMethod.GET)
    public List<Reservation> updateReservation(@RequestBody Reservation reservation) {
        try {
            repository.save(reservation);
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //adds a new Reservations
    @RequestMapping(value = "/addBooking", method = RequestMethod.POST)
    public List<Reservation> addBooking(@RequestBody Reservation reservation) {
        try {
            repository.save(reservation);
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //removes any existing booking
    @RequestMapping(value = "/removeBooking/{id}", method = RequestMethod.POST)
    public List<Reservation> removeBooking(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
