package DistributedSystem.ticketsystem.domain.concert.application;


import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ConcertService {
    Page<Concert> searchName(String ConcertName, int page);
}
