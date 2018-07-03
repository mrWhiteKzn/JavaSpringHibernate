package exampro.dao.implementions;

import exampro.dao.UserDao;
import exampro.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDaoImp implements UserDao {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity findByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("select u from UserEntity u where u.login = :login");
        query.setParameter("login", login);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        return userEntity;
    }

    @Override
    public void save(UserEntity userEntity) {
        sessionFactory.getCurrentSession().save(userEntity);
    }


}
