package DistributedSystem.ticketsystem.domain.user.repository;


import DistributedSystem.ticketsystem.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends  JpaRepository<User, Long> {
        Optional<User> findById(String id);
        Optional<User> findUserByIdAndPassword(String id, String password);
        Boolean existsById(@Param("id") String id);

}
