package DistributedSystem.ticketsystem.domain.concert.repository;


import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

    Page<Concert> findByNameContaining(@Param("concert_name") String name, Pageable pageable);
}
