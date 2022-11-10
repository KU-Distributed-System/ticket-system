package DistributedSystem.ticketsystem.domain.user.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserSigninDto {

    @NotEmpty
    private String id;
    @NotEmpty
    private String password;
}