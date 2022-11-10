package DistributedSystem.ticketsystem.domain.user.application;



import DistributedSystem.ticketsystem.domain.user.domain.User;
import DistributedSystem.ticketsystem.domain.user.dto.UserInfoDto;
import DistributedSystem.ticketsystem.domain.user.dto.UserSignupDto;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    //회원가입
    User save(UserSignupDto userDto) throws Exception;

    //회원가입 시 아이디 중복 체크
    boolean checkUserIdDuplicate(String id);

    //내 정보 조회
    UserInfoDto getMyInfo(String id) throws Exception;


}
