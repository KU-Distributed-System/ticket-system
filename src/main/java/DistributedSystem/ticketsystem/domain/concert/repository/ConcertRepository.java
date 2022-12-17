package DistributedSystem.ticketsystem.domain.concert.repository;


import DistributedSystem.ticketsystem.domain.concert.domain.Concert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

    List<Concert> findByNameContaining(@Param("concert_name") String name);
}
