package DistributedSystem.ticketsystem.domain.seat.domain;


import DistributedSystem.ticketsystem.domain.theater.domain.Theater;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "seat")
@Getter
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType; // A, B, C, D

    private Integer seatNumber; // 1, 2, 3, 4

    private Boolean isAvailable;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;


    public void expire() {
        this.isAvailable = false;
    }
}
