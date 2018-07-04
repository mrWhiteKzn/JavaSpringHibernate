package exampro.service;

import exampro.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserEntity findByUserLogin(String login);

    void save(UserEntity userEntity);

    UserDetails loadUserByUsername(String s);
}
