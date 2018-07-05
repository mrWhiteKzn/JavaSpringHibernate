package exampro.dao.implementions;

import exampro.dao.AnswerDao;
import exampro.entity.AnswerEntity;
import exampro.entity.QuestionEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnswerDaoImp implements AnswerDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(AnswerEntity answerEntity, QuestionEntity questionEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(answerEntity);
    }

    @Override
    public void saveorUpdateList(List<AnswerEntity> answerEntityList, QuestionEntity questionEntity) {
        Session session = sessionFactory.getCurrentSession();

        answerEntityList.forEach(answerEntity -> {
            answerEntity.setQuestionEntity(questionEntity);

            AnswerEntity answerEntityFromDb = session.load(AnswerEntity.class, answerEntity.getId());
            if (!answerEntityFromDb.equals(answerEntity)) {
                answerEntityFromDb.setAnswerText(answerEntity.getAnswerText());
                answerEntityFromDb.setCorrect(answerEntity.isCorrect());
                session.update(answerEntityFromDb);
            }
        });
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
        Session session = sessionFactory.getCurrentSession();
        AnswerEntity answerEntity = session.get(AnswerEntity.class, id);
        return answerEntity;
    }
}
