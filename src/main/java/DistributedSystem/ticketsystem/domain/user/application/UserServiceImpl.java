package DistributedSystem.ticketsystem.domain.user.application;


import DistributedSystem.ticketsystem.domain.user.domain.User;
import DistributedSystem.ticketsystem.domain.user.dto.UserInfoDto;
import DistributedSystem.ticketsystem.domain.user.dto.UserSignupDto;
import DistributedSystem.ticketsystem.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor //final 키워드가 붙은 것을 생성자 의존 관계 주입
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User save(UserSignupDto UserSignupDto) throws Exception {
        User user = UserSignupDto.toEntity();
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public UserInfoDto getMyInfo(String id) throws Exception {

        Optional<User> byUserId = userRepository.findById(id);
        User getUser = byUserId.get();

        UserInfoDto userInfoDto = new UserInfoDto(getUser);
        return userInfoDto;

    }

    @Override
    public boolean checkUserIdDuplicate(String id){
        return userRepository.existsById(id);
    }


}
