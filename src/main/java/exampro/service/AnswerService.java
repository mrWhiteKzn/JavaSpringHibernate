package exampro.service;

import exampro.config.HibernateUtil;
import exampro.dao.AnswerDao;
import exampro.entity.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class AnswerService {
    AnswerDao answerDao;
    TestService testService;
    QuestionService questionService;

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

        Session session = HibernateUtil.getSessionFactory().openSession();
        answersMap.forEach((id,text) ->{
            AnswerEntity answerEntity = answerDao.getAnswerEntityById(Integer.parseInt(id));

            answerEntity.setAnswerText(text);
//            answerEntity.setQuestionEntity(questionService.getQuestion(Integer.parseInt(id)));
            answerEntity.setCorrect(false);

            answerDao.saveOrUpdate(answerEntity,questionEntity);
        });
        session.close();
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
