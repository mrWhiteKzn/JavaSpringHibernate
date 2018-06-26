package exampro.dao;

import exampro.config.HibernateUtil;
import exampro.entity.TestEntity;
import org.hibernate.Session;
import java.util.List;

public class TestDaoImp implements TestDao{

    @Override
    public TestEntity getTest(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TestEntity testEntity = session.get(TestEntity.class, id);
        session.close();
        return testEntity;
    }

    @Override
    public List<TestEntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<TestEntity> testEntityList = session.createQuery("from TestEntity").list();
        session.close();
        return testEntityList;
    }

    @Override
    public void saveOrUpdate(TestEntity testEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.saveOrUpdate(testEntity);
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TestEntity test = session.load(TestEntity.class, id);
        session.delete(test);
        session.flush();
        session.close();
    }
}
