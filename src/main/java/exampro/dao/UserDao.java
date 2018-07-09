package exampro.dao;

import exampro.entity.UserEntity;

import java.util.List;

public interface UserDao {
    UserEntity findByLogin(String login);

    void save(UserEntity userEntity);

    List<UserEntity> findAll();

    UserEntity getById(int id);
}
