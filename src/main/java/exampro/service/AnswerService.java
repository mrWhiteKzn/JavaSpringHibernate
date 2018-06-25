package exampro.service;

import exampro.containerClasses.QuestionContainer;
import exampro.dao.AnswerDao;
import exampro.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerService {
    private AnswerDao answerDao;
    private TestService testService;
    private QuestionService questionService;

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(AnswerEntity answerEntity, QuestionEntity questionEntity){
        answerDao.saveOrUpdate(answerEntity, questionEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveorUpdateList(String[] answers, QuestionEntity questionEntity){
        for(String answer : answers){
            AnswerEntity answerEntity = new AnswerEntity();
            answerEntity.setAnswerText(answer);
            answerEntity.setQuestionEntity(questionEntity);
            answerEntity.setCorrect(false);

            answerDao.saveOrUpdate(answerEntity,questionEntity);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateAnswers(QuestionContainer questionContainer) {
        answerDao.saveorUpdateList(questionContainer.getAnswerEntityList(), questionContainer.getQuestionEntity());
    }

    @Transactional(propagation = Propagation.REQUIRED)
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
