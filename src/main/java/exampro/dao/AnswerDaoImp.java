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
        session.flush();
        session.close();
    }

    @Override
    public void saveorUpdateList(List<AnswerEntity> answerEntityList, QuestionEntity questionEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        answerEntityList.forEach(answerEntity -> {
            answerEntity.setQuestionEntity(questionEntity);
            System.out.println("ID: " + answerEntity.getId());
            System.out.println("Answer Text: " + answerEntity.getAnswerText());
            System.out.println("Question entity: " + answerEntity.getQuestionEntity());
            System.out.println("is correct: " + answerEntity.isCorrect());

            AnswerEntity answerEntityFromDb = session.load(AnswerEntity.class, answerEntity.getId());
            if (!answerEntityFromDb.equals(answerEntity)) {
                answerEntityFromDb.setAnswerText(answerEntity.getAnswerText());
                answerEntityFromDb.setCorrect(answerEntity.isCorrect());
                session.update(answerEntityFromDb);
            }


        });
        session.close();
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
        AnswerEntity answerEntity = session.get(AnswerEntity.class, id);
        session.close();
        return answerEntity;
    }
}
