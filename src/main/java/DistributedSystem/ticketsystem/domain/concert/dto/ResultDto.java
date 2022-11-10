package DistributedSystem.ticketsystem.domain.concert.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultDto<T> {
    private int curPage;
    private int totalPage;
    private T concertBoardList;
}
