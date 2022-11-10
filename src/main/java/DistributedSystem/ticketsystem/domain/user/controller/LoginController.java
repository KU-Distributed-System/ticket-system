package DistributedSystem.ticketsystem.domain.user.controller;

import DistributedSystem.ticketsystem.domain.user.application.LoginService;
import DistributedSystem.ticketsystem.domain.user.domain.User;
import DistributedSystem.ticketsystem.domain.user.dto.LoginUserDto;
import DistributedSystem.ticketsystem.domain.user.dto.UserSigninDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;


    //filter를 적용한 로그인
    @PostMapping("/user/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserSigninDto form, BindingResult bindingResult,
                                   HttpServletRequest request) {

        //유효하지 않은 입력 폼 입력 시 로그인 폼으로 이동
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("올바른 id, password 값을 입력하세요.", HttpStatus.BAD_REQUEST);
        }

        Optional<User> loginUser = (Optional<User>) loginService.login(form.getId(), form.getPassword());

        //조회된 회원이 없는 경우
        if (loginUser.isEmpty()) {
            bindingResult.reject("loginfail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return new ResponseEntity<>("아이디 혹은 비밀번호가 올바르지 않습니다.", HttpStatus.BAD_REQUEST);
        }

        HttpSession session = request.getSession(true);
        //세션에 로그인 회원 정보를 보관한다.
        session.setAttribute(session.getId(), loginUser.get());
        session.setAttribute("memberId",loginUser.get().getId());

        User user = loginUser.get();
        LoginUserDto loginUserDto = new LoginUserDto(user);
        return new ResponseEntity<>(loginUserDto, HttpStatus.OK);
    }


    //HttpSession 을 이용한 로그아웃
    @PostMapping("/user/logout")
    public ResponseEntity<?> logoutV3(HttpServletRequest request) {
        //세션을 없애는 것이 목적이기 때문에 false 옵션을 주고 조회해 온다.
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate(); //세션 만료
            return new ResponseEntity<>("로그아웃 완료", HttpStatus.OK);
        }
        return new ResponseEntity<>("세션이 만료되었거나 로그인을 하지 않았습니다.", HttpStatus.UNAUTHORIZED);
    }
}