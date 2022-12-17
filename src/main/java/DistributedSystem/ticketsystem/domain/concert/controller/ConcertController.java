package DistributedSystem.ticketsystem.domain.concert.controller;


import DistributedSystem.ticketsystem.domain.concert.application.ConcertService;
import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ConcertController {

    private final ConcertService concertService;


    @GetMapping("/concert/search") //page:default 페이지, size:한 페이지 게시글 수, sort:정렬기준컬럼, direction:정렬순서
    public ResponseEntity<?> search(@RequestParam("concertName") String concertName){

        List<Concert> concerts = concertService.searchName(concertName);


        return new ResponseEntity<>(concerts, HttpStatus.OK);

    }
}


