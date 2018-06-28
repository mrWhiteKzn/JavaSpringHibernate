package exampro.service;

import exampro.dao.UserDao;
import exampro.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void deleteUser(UserEntity userEntity) {
//        userDao.delete(userEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity getUser(int id) {
//        return userDao.findOne(id);
        return null;
    }
}
