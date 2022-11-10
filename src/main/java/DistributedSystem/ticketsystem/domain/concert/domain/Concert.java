package DistributedSystem.ticketsystem.domain.concert.domain;


import DistributedSystem.ticketsystem.domain.theater.domain.Theater;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "concert")
@Getter
@NoArgsConstructor
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concert_id")
    private Long Id;

    @Column(name = "concert_name")
    private String name;

    private String description;

    private LocalDateTime dateTime;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

}
