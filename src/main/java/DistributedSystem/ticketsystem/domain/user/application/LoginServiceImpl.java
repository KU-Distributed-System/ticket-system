package DistributedSystem.ticketsystem.domain.user.application;

import DistributedSystem.ticketsystem.domain.user.domain.User;
import DistributedSystem.ticketsystem.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;

    //로그인
    public Optional<User> login(String loginId, String password){
        Optional<User> findUser = userRepository.findUserByIdAndPassword(loginId, password);

        //검색이 안되면 null 반환
        if(findUser == null){
            return null;
        }
        return findUser;
    }

    //로그아웃
}
