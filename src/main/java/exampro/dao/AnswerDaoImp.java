package exampro.dao;

import exampro.config.HibernateUtil;
import exampro.entity.AnswerEntity;
import exampro.entity.QuestionEntity;
import org.hibernate.Session;
import java.util.List;

public class AnswerDaoImp implements AnswerDao {

    @Override
    public void saveOrUpdate(AnswerEntity answerEntity, QuestionEntity questionEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.saveOrUpdate(answerEntity);
        session.close();
    }

    @Override
    public void saveorUpdateList(List<AnswerEntity> answerEntityList, QuestionEntity questionEntity) {

    }

    @Override
    public void delete(AnswerEntity answerEntity) {

    }

    @Override
    public List<AnswerEntity> getAnswerList() {
        return null;
    }

    @Override
    public AnswerEntity getAnswerEntityById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AnswerEntity answerEntity = session.load(AnswerEntity.class, id);
        session.close();
        return answerEntity;
    }
}
