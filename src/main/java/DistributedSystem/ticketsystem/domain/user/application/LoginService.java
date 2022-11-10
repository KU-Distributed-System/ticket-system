package DistributedSystem.ticketsystem.domain.user.application;


import DistributedSystem.ticketsystem.domain.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface LoginService {
    Optional<User> login(String loginId, String password);
}
