package DistributedSystem.ticketsystem.domain.seat.repository;

import DistributedSystem.ticketsystem.domain.seat.domain.Seat;
import DistributedSystem.ticketsystem.domain.seat.domain.SeatType;
import DistributedSystem.ticketsystem.domain.theater.domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    Optional<Seat> findByTheaterAndSeatTypeAndSeatNumber(Theater theater, SeatType seatType, Integer seatNumber);
}
