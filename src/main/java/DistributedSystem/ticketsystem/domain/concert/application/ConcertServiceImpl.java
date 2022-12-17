package DistributedSystem.ticketsystem.domain.concert.application;


import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import DistributedSystem.ticketsystem.domain.concert.repository.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService{

    private final ConcertRepository concertRepository;

    //콘서트 검색 Page로 repository에서 받아와서 return
    @Transactional
    @Override
    public List<Concert> searchName(String name){
        List<Concert> concerts = concertRepository.findByNameContaining(name);
        return concerts;
    }
}
