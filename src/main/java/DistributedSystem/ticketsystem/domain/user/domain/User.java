package DistributedSystem.ticketsystem.domain.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User{

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String id, String password){
        this.id = id;
        this.password = password;
    }
}