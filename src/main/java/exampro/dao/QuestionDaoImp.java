package exampro.dao;

import exampro.config.HibernateUtil;
import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionDaoImp implements QuestionDao {

    @Autowired
    SessionFactory sessionFactory;

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public void update(QuestionEntity questionEntity) {
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
        QuestionEntity questionEntity = session.load(QuestionEntity.class, id);
        questionEntity.setTestEntity(null);
        session.delete(questionEntity);
//        session.flush();
//        session.close();
    }

    @Override
    public List<QuestionEntity> getAllByTestId(TestEntity testEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<QuestionEntity> questionEntityList = session.createQuery("from QuestionEntity where test_id= " + testEntity.getId()).list();
        session.close();
        return questionEntityList;
    }

    @Override
    public QuestionEntity getQuestion(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(QuestionEntity.class, id);
    }

    @Override
    public void saveOrUpdate(QuestionEntity questionEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.saveOrUpdate(questionEntity);
    }

    @Override
    public void saveOrUpdate(QuestionEntity questionEntity, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TestEntity testEntity = session.get(TestEntity.class, id);
        questionEntity.setTestEntity(testEntity);
        session.saveOrUpdate(questionEntity);
        session.close();
    }
}
