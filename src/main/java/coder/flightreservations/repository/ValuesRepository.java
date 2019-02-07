package coder.flightreservations.repository;

import coder.flightreservations.models.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValuesRepository extends JpaRepository<Seats, Long> {

    @Query("select s.seatNo from Seats s where s.ticketType = :ticketType")
    List<Seats> findByTicketType(@Param("ticketType")Integer ticketType);
}
