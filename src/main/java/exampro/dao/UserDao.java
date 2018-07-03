package exampro.dao;

import exampro.entity.UserEntity;

public interface UserDao {
    UserEntity findByLogin(String login);

    void save(UserEntity userEntity);
}
