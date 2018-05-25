package exampro.dao;

import exampro.config.HibernateUtil;
import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class QuestionDaoImp implements QuestionDao {
    @Override
    public void update(QuestionEntity questionEntity) {

    }

    @Override
    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        QuestionEntity questionEntity = session.load(QuestionEntity.class, id);
        session.delete(questionEntity);
        transaction.commit();
        session.close();
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
        return session.load(QuestionEntity.class, id);
    }

    @Override
    public void saveOrUpdate(QuestionEntity questionEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.saveOrUpdate(questionEntity);
    }

    @Override
    public void saveOrUpdate(QuestionEntity questionEntity, int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TestEntity testEntity = session.load(TestEntity.class, id);
        questionEntity.setTestEntity(testEntity);
        session.save(questionEntity);
        session.getTransaction().commit();
    }
}
