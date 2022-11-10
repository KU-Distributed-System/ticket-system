package DistributedSystem.ticketsystem.domain.user.dto;


import DistributedSystem.ticketsystem.domain.user.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoDto {

    private String id;


    @Builder
    public UserInfoDto(User user) {
        this.id = user.getId();
    }
}
