package DistributedSystem.ticketsystem.domain.book.application;


import DistributedSystem.ticketsystem.domain.book.dto.BookDto;
import DistributedSystem.ticketsystem.domain.seat.domain.SeatType;

import java.util.List;

public interface BookService {

    void book(String userId, Long theaterId, Long concertId, SeatType seatType, Integer seatNumber);


    List<BookDto.InfoRes> getBooks(String userId);

}
