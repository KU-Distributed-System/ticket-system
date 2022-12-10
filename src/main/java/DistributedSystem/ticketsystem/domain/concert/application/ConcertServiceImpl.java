package DistributedSystem.ticketsystem.domain.concert.application;


import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import DistributedSystem.ticketsystem.domain.concert.repository.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService{

    private final ConcertRepository concertRepository;


    //콘서트 검색 Page로 repository에서 받아와서 return
    @Transactional
    @Override
    public Page<Concert> searchName(String name, int page){
        PageRequest pageRequest = PageRequest.of(page, 5, Sort.by("concert_id").descending());
        Page<Concert> concerts = concertRepository.findByNameContaining(name, pageRequest);
        return concerts;
    }
}
