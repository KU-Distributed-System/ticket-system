package DistributedSystem.ticketsystem.domain.book.application;


import DistributedSystem.ticketsystem.domain.book.domain.Book;
import DistributedSystem.ticketsystem.domain.book.dto.BookDto;
import DistributedSystem.ticketsystem.domain.book.repository.BookRepository;
import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import DistributedSystem.ticketsystem.domain.concert.repository.ConcertRepository;
import DistributedSystem.ticketsystem.domain.seat.domain.Seat;
import DistributedSystem.ticketsystem.domain.seat.domain.SeatType;
import DistributedSystem.ticketsystem.domain.seat.repository.SeatRepository;
import DistributedSystem.ticketsystem.domain.theater.domain.Theater;
import DistributedSystem.ticketsystem.domain.theater.repository.TheaterRepository;
import DistributedSystem.ticketsystem.domain.user.domain.User;
import DistributedSystem.ticketsystem.domain.user.repository.UserRepository;
import DistributedSystem.ticketsystem.global.error.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final SeatRepository seatRepository;
    private final TheaterRepository theaterRepository;
    private final ConcertRepository concertRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void book(String userId, Long theaterId, Long concertId, SeatType seatType, Integer seatNumber) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));

        Theater theater = theaterRepository.findById(theaterId)
                .orElseThrow(() -> new EntityNotFoundException("영화관을 찾을 수 없습니다."));

        Concert concert = concertRepository.findById(concertId)
                .orElseThrow(() -> new EntityNotFoundException("공연을 찾을 수 없습니다."));


        Seat seat = seatRepository.findByTheaterAndSeatTypeAndSeatNumber(theater, seatType, seatNumber)
                .orElseThrow(() -> new EntityNotFoundException("좌석을 찾을 수 없습니다."));

        if (!seat.getIsAvailable()) {
            throw new BusinessException(400, "이미 만료된 좌석입니다.");
        }

        seat.expire();
        Book book = Book.createBook(user, seat, concert);

        bookRepository.save(book);

    }

    @Override
    public List<BookDto.InfoRes> getBooks(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));

        List<Book> books = bookRepository.findByUser(user);

        List<BookDto.InfoRes> result = books.stream().map(BookDto.InfoRes::from).collect(Collectors.toList());
        return result;
    }
}
