package DistributedSystem.ticketsystem.domain.concert.controller;


import DistributedSystem.ticketsystem.domain.concert.application.ConcertService;
import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import DistributedSystem.ticketsystem.domain.concert.dto.ConcertDto;
import DistributedSystem.ticketsystem.domain.concert.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ConcertController {

    private final ConcertService concertService;


    @GetMapping("/concert/search") //page:default 페이지, size:한 페이지 게시글 수, sort:정렬기준컬럼, direction:정렬순서
    public ResponseEntity<?> search(@RequestParam("concertName") String concertName,
                                    @RequestParam(value = "page", defaultValue = "0") int page){

        Page<Concert> concerts = concertService.searchName(concertName, page);

        if(page != 0 && page >= concerts.getTotalPages()){
            return new ResponseEntity<>("해당 페이지는 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        //프록시 객체 초기화 + DTO 로 변환
        List<Concert> content = concerts.getContent();
        List<ConcertDto> result = content.stream()
                .map(v -> new ConcertDto(v))
                .collect(Collectors.toList());

        return new ResponseEntity<>(new ResultDto<>(page+1,concerts.getTotalPages(),result), HttpStatus.OK);

    }
}


