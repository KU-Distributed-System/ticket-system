package DistributedSystem.ticketsystem.domain.concert.dto;


import DistributedSystem.ticketsystem.domain.concert.domain.Concert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConcertDto {
    private Long id;
    private String name;

    public ConcertDto(Concert concert) {
        name = concert.getName();
    }
}
