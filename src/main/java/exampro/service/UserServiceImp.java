package exampro.service;

import exampro.dao.UserDao;
import exampro.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity findByUserLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    @Transactional
    public UserEntity getById(int id) {
        return userDao.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByLogin(s);
    }

    @Override
    @Transactional
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

}
