package DistributedSystem.ticketsystem.domain.book.domain;



import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import DistributedSystem.ticketsystem.domain.seat.domain.Seat;
import DistributedSystem.ticketsystem.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long Id;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "concert_id", nullable = false)
    private Concert concert;

    public static Book createBook(User user, Seat seat, Concert concert) {
        return Book.builder()
                .user(user)
                .seat(seat)
                .concert(concert)
                .build();
    }


    @Builder
    public Book(User user, Seat seat, Concert concert) {
        this.user = user;
        this.seat = seat;
        this.concert = concert;
    }
}
