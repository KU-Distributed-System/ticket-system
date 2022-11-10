package DistributedSystem.ticketsystem.domain.book.controller;


import DistributedSystem.ticketsystem.domain.book.application.BookService;
import DistributedSystem.ticketsystem.domain.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Void> book(
            @RequestBody @Valid BookDto.BookReq request
    ) {
        bookService.book(request.getUserId(), request.getTheaterId(), request.getConcertId(), request.getSeatType(), request.getSeatNumber());
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BookDto.InfoRes>> getBooks(
            @PathVariable String userId
    ) {
        List<BookDto.InfoRes> response = bookService.getBooks(userId);
        return ResponseEntity.ok(response);
    }


}
