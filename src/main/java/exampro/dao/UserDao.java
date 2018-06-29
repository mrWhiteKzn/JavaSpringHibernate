package exampro.dao;

import exampro.entity.UserEntity;

public interface UserDao {
    UserEntity getUser(String login);
}
