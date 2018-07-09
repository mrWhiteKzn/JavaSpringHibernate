package exampro.service;

import exampro.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserEntity findByUserLogin(String login);

    UserEntity getById(int id);

    void save(UserEntity userEntity);

    UserDetails loadUserByUsername(String s);

    List<UserEntity> findAll();
}
