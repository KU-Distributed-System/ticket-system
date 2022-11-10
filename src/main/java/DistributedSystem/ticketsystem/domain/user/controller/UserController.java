package DistributedSystem.ticketsystem.domain.user.controller;

import DistributedSystem.ticketsystem.domain.user.application.UserService;
import DistributedSystem.ticketsystem.domain.user.domain.User;
import DistributedSystem.ticketsystem.domain.user.dto.UserInfoDto;
import DistributedSystem.ticketsystem.domain.user.dto.UserSignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원 가입
     */
    @PostMapping(value = "/user/new")
    public ResponseEntity<?> create(@Valid @RequestBody UserSignupDto userSignupDto,
                                    BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        userService.save(userSignupDto);
        return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
    }



    /**
     * 내정보조회
     */
    @GetMapping("/user")
    public UserInfoDto getMyInfo(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute(session.getId());

        UserInfoDto getUserInfo = userService.getMyInfo(user.getId());


        return getUserInfo;
    }

}