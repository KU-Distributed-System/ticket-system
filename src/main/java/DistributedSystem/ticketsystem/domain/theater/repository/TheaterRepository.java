package DistributedSystem.ticketsystem.domain.theater.repository;


import DistributedSystem.ticketsystem.domain.theater.domain.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
