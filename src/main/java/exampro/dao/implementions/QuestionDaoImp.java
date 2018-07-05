package exampro.dao.implementions;

import exampro.dao.QuestionDao;
import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionDaoImp implements QuestionDao {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void update(QuestionEntity questionEntity) {
        String hqlQuery = "UPDATE Question q set q.name = :newName WHERE q.id = :id";
        sessionFactory.getCurrentSession().createQuery("UPDATE QuestionEntity q set q.questionText = :newText WHERE q.id = :id")
                .setParameter("newText", questionEntity.getQuestionText())
                .setParameter("id", questionEntity.getId())
                .executeUpdate();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        QuestionEntity questionEntity = session.load(QuestionEntity.class, id);
        questionEntity.setTestEntity(null);
        session.delete(questionEntity);
    }

    @Override
    public List<QuestionEntity> getAllByTestId(TestEntity testEntity) {
        Session session = sessionFactory.getCurrentSession();
        List<QuestionEntity> questionEntityList = session.createQuery("from QuestionEntity where test_id= " + testEntity.getId()).list();
        return questionEntityList;
    }

    @Override
    public QuestionEntity getQuestion(int id) {
        return sessionFactory.getCurrentSession().get(QuestionEntity.class, id);
    }

    @Override
    public void saveOrUpdate(QuestionEntity questionEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(questionEntity);
    }

    @Override
    public void saveOrUpdate(QuestionEntity questionEntity, int id) {
        Session session = sessionFactory.getCurrentSession();
        TestEntity testEntity = session.get(TestEntity.class, id);
        questionEntity.setTestEntity(testEntity);
        session.saveOrUpdate(questionEntity);
    }
}
