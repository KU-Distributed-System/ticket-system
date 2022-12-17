package DistributedSystem.ticketsystem.domain.concert.application;


import DistributedSystem.ticketsystem.domain.concert.domain.Concert;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConcertService {
    List<Concert> searchName(String ConcertName);
}
