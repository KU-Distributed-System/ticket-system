package DistributedSystem.ticketsystem.domain.book.dto;

import DistributedSystem.ticketsystem.domain.book.domain.Book;
import DistributedSystem.ticketsystem.domain.seat.domain.SeatType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class BookDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class BookReq {

        @NotNull(message = "유저 아이디는 필수값 입니다.")
        private String userId;

        @NotNull(message = "영화관 아이디는 필수값 입니다.")
        private Long theaterId;

        @NotNull(message = "좌석타입은 필수값 입니다")
        private SeatType seatType;

        @NotNull(message = "좌석번호는 필수값 입니다")
        private Integer seatNumber;

        @NotNull(message = "공연 아이디는 필수값 입니다.")
        private Long concertId;

    }

    @Getter
    @Builder
    public static class InfoRes {

        private String concertName;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        private LocalDateTime concertTime;

        private String theaterName;

        private String seatType;

        private Integer seatNumber;


        public static InfoRes from(Book book) {
            return InfoRes.builder()
                    .concertName(book.getConcert().getName())
                    .concertTime(book.getConcert().getDateTime())
                    .theaterName(book.getSeat().getTheater().getName())
                    .seatType(book.getSeat().getSeatType().toString())
                    .seatNumber(book.getSeat().getSeatNumber())
                    .build();
        }



    }

}
