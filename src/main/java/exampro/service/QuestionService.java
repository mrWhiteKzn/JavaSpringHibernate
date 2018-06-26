package exampro.service;

import exampro.dao.QuestionDao;
import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    SessionFactory sessionFactory;

    private QuestionDao questionDao;

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(int id){
        System.out.println("##### STARTED TRANSACTION METHOD ####");
        questionDao.delete(id);
    }

    public QuestionEntity getQuestion(int id){
        return questionDao.getQuestion(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(QuestionEntity questionEntity) { questionDao.saveOrUpdate(questionEntity); }

    public List<QuestionEntity> getQuestionsList(TestEntity testEntity) {
        List<QuestionEntity> questionList = questionDao.getAllByTestId(testEntity);
        return questionList;
    }
}
