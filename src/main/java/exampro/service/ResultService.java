package exampro.service;

import exampro.dao.ResultDao;
import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Iterator;
import java.util.Set;

@Service
public class ResultService {

    private TestService testService;
    private AnswerService answerService;
    private QuestionService questionService;
    private ResultDao resultDao;


    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setResultDao(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void saveTestResult(MultiValueMap<String, String> selectedAnswers, int testId) {
        ResultEntity result = new ResultEntity();

        result.setTestEntity(testService.getTestEntity(testId));
        result.setUserEntity(new UserEntity("Dmitry", "White"));
        result.setSqlDate(new java.sql.Date(System.currentTimeMillis()));

        resultDao.saveResult(result);

        selectedAnswers.forEach((k, v) -> {
            ResultDetailEntity resultDetailEntity = new ResultDetailEntity();
            resultDetailEntity.setResultEntity(result);
            resultDetailEntity.setQuestionEntity(questionService.getQuestion(Integer.parseInt(k)));

            for (String s : v) {
                resultDetailEntity.setAnswerEntity(answerService.getAnswerEntityById(Integer.parseInt(s)));
                resultDao.saveResultDetail(resultDetailEntity);
            }

        });
    }

    public ResultEntity getResultEntityById(int id){
        return resultDao.getResultEntityById(id);
    }
}
