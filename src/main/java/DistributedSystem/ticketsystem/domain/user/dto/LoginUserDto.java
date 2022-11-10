package DistributedSystem.ticketsystem.domain.user.dto;


import DistributedSystem.ticketsystem.domain.user.domain.User;
import lombok.Data;

@Data
public class LoginUserDto {
    private String Id;

    public LoginUserDto(User user) {
        Id = user.getId();
    }

}
