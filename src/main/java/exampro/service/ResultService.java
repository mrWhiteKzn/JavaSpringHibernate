package exampro.service;

import exampro.dao.ResultDao;
import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.reports.ExamResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
public class ResultService {

    private TestService testService;
    private AnswerService answerService;
    private QuestionService questionService;
    private ResultDao resultDao;
    private UserService userService;

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

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveTestResult(MultiValueMap<String, String> selectedAnswers, int testId) {
        ResultEntity result = new ResultEntity();

        result.setTestEntity(testService.getTestEntity(testId));
        result.setUserEntity(userService.getUser(1));
        result.setSqlDate(new java.sql.Date(System.currentTimeMillis()));

        System.out.println("================= LET'S SEE WHAT IS IN THE RESULT " + result.toString());

        resultDao.saveResult(result);
        System.out.println("================= HAVE JUST SAVED " + result.toString());

        selectedAnswers.forEach((k, v) -> {
            ResultDetailEntity resultDetailEntity = new ResultDetailEntity();
            resultDetailEntity.setResultEntity(result);
            resultDetailEntity.setQuestionEntity(questionService.getQuestion(Integer.parseInt(k)));

            for (String s : v) {
                System.out.println("ЧТО ТО ЕЩЕ" + k + " " + v);
                resultDetailEntity.setAnswerEntity(answerService.getAnswerEntityById(Integer.parseInt(s)));
                resultDao.saveResultDetail(resultDetailEntity);
            }

        });
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ResultEntity getResultEntityById(int id){
        return resultDao.getResultEntityById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<ExamResult> getRecentlyResults() {
        return resultDao.getRecentlyResults();
    }
}
