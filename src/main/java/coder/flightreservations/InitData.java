package coder.flightreservations;

import coder.flightreservations.models.Reservation;
import coder.flightreservations.models.Seats;
import coder.flightreservations.repository.ReservationRepository;
import coder.flightreservations.repository.ValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sun.java2d.pipe.ValidatePipe;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private ReservationRepository repository;
    private ValuesRepository valuesRepository;

    @Autowired
    public InitData(ReservationRepository repository, ValuesRepository valuesRepository) {
        this.repository = repository;
        this.valuesRepository = valuesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //reservation table
        //Assuiming that there are 3 reservations
        List<Reservation> reservations = new ArrayList<>();

        reservations.add(new Reservation("Sam", "a1", 1, "S1"));
        reservations.add(new Reservation("Dan", "b2", 3, "D1"));
        reservations.add(new Reservation("Ken", "c3", 2, "K1"));

        repository.saveAll(reservations);


        //val table for seats
        List<Seats> seats = new ArrayList<>();

        seats.add(new Seats(1,"a1"));
        seats.add(new Seats(1,"a2"));
        seats.add(new Seats(1,"a3"));
        seats.add(new Seats(1,"a4"));
        seats.add(new Seats(1,"a5"));

        seats.add(new Seats(2,"b1"));
        seats.add(new Seats(2,"b2"));
        seats.add(new Seats(2,"b3"));
        seats.add(new Seats(2,"b4"));
        seats.add(new Seats(2,"b5"));

        seats.add(new Seats(2,"c1"));
        seats.add(new Seats(2,"c2"));
        seats.add(new Seats(2,"c3"));
        seats.add(new Seats(2,"c4"));
        seats.add(new Seats(2,"b5"));

        valuesRepository.saveAll(seats);
    }
}
