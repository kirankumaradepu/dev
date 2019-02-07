package coder.flightreservations.repository;

import coder.flightreservations.models.Reservation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Override
    Optional<Reservation> findById(Long aLong);
}
