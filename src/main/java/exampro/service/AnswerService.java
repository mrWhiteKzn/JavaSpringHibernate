package exampro.service;

import exampro.dao.AnswerDao;
import exampro.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

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

    public void saveorUpdateList(String[] answers, QuestionEntity questionEntity){
        for(String answer : answers){
            AnswerEntity answerEntity = new AnswerEntity();
            answerEntity.setAnswerText(answer);
            answerEntity.setQuestionEntity(questionEntity);
            answerEntity.setCorrect(false);

            answerDao.saveOrUpdate(answerEntity,questionEntity);
        }
    }

    public void updateAnswers(Map<String, String> answersMap, QuestionEntity questionEntity){
        answersMap.forEach((id,text) ->{
            AnswerEntity answerEntity = answerDao.getAnswerEntityById(Integer.parseInt(id));
            answerEntity.setAnswerText(text);
            answerEntity.setQuestionEntity(questionEntity);
            answerEntity.setCorrect(false);

            answerDao.saveOrUpdate(answerEntity,questionEntity);
        });
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
