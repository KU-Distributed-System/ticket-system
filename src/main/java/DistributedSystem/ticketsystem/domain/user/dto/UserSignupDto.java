package DistributedSystem.ticketsystem.domain.user.dto;

import DistributedSystem.ticketsystem.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor //기본 생성자 생성
@AllArgsConstructor
@Getter
@Setter
public class UserSignupDto {
    @NotBlank(message = "아이디를 입력하세요.")
    @NotEmpty
    private String id;
    @NotBlank(message = "비밀번호를 입력하세요.")
    @NotEmpty
    private String password;


    // DTO -> 객체
    public User toEntity(){
        return User.builder()
                .id(id)
                .password(password)
                .build();
    }


}
