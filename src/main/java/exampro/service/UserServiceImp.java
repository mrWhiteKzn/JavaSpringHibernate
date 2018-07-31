package exampro.service;

import exampro.dao.UserDao;
import exampro.entity.UserEntity;
import exampro.entity.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

public class UserServiceImp implements UserService {

    private UserDao userDao;
    private PasswordEncoder passswordEncoder;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPassswordEncoder(PasswordEncoder passswordEncoder) {
        this.passswordEncoder = passswordEncoder;
    }

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
        userEntity.setActive(true);
        userEntity.setRoles(Collections.singleton(UserRole.Student));
        userEntity.setPassword(passswordEncoder.encode(userEntity.getPassword()));

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
