package DistributedSystem.ticketsystem.domain.book.controller;


import DistributedSystem.ticketsystem.domain.book.application.BookService;
import DistributedSystem.ticketsystem.domain.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> book(
            @RequestBody @Valid BookDto.BookReq request
    ) {
        bookService.book(request.getUserId(), request.getTheaterId(), request.getConcertId(), request.getSeatType(), request.getSeatNumber());
        return new ResponseEntity<>("좌석 예매 완료", HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BookDto.InfoRes>> getBooks(
            @PathVariable String userId
    ) {
        List<BookDto.InfoRes> response = bookService.getBooks(userId);
        return ResponseEntity.ok(response);
    }


}
