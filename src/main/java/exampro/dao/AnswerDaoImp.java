package exampro.dao;

import exampro.config.HibernateUtil;
import exampro.entity.AnswerEntity;
import exampro.entity.QuestionEntity;
import org.hibernate.Session;

import java.util.List;

public class AnswerDaoImp implements AnswerDao {

    @Override
    public void saveOrUpdate(AnswerEntity answerEntity, QuestionEntity questionEntity) {
        System.out.println("ВЫВОД ОТВЕТОВ: "+ answerEntity.toString());
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
}
