package exampro.service;

import exampro.dao.UserDao;
import exampro.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity findByUserLogin(String login) {
        return userDao.findByLogin(login);
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
}
