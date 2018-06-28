package exampro.dao.implementions;

import exampro.dao.TestDao;
import exampro.entity.TestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestDaoImp implements TestDao {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TestEntity getTest(int id) {
        return sessionFactory.getCurrentSession().get(TestEntity.class, id);
    }

    @Override
    public List<TestEntity> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from TestEntity").list();
    }

    @Override
    public void saveOrUpdate(TestEntity testEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(testEntity);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        TestEntity test = session.load(TestEntity.class, id);
        session.delete(test);
    }
}
