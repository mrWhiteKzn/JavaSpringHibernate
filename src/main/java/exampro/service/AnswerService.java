package exampro.service;

import exampro.dao.AnswerDao;
import exampro.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnswerService {
    AnswerDao answerDao;
    TestService testService;

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public void saveOrUpdate(AnswerEntity answerEntity, QuestionEntity questionEntity){
        answerDao.saveOrUpdate(answerEntity, questionEntity);
    }

    public void saveorUpdateList(String[] answerTextArray, QuestionEntity questionEntity){
        for(String answer : answerTextArray){
            AnswerEntity answerEntity = new AnswerEntity();
            answerEntity.setAnswerText(answer);
            answerEntity.setQuestionEntity(questionEntity);
            answerEntity.setCorrect(false);

            answerDao.saveOrUpdate(answerEntity, questionEntity);
        }
    }

    public void delete(AnswerEntity answerEntity){
        answerDao.delete(answerEntity);
    }

    public List<AnswerEntity> getAnswerList(){
        return answerDao.getAnswerList();
    }

    public AnswerEntity getAnswerEntityById(int id) {
        return answerDao.getAnswerEntityById(id);
    }
}
