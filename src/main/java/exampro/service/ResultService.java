package exampro.service;

import exampro.dao.ResultDao;
import exampro.entity.*;
import exampro.reports.ExamResult;
import exampro.reports.ExamResultDetail;
import exampro.reports.ExamResultOfUser;
import exampro.reports.QuestionResultDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
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


    @Transactional(propagation = Propagation.REQUIRED)
    public void saveTestResult(MultiValueMap<String, String> selectedAnswers, int testId, UserEntity userEntity) {
        TestEntity testEntity = testService.getTestEntity(testId);

        ResultEntity result = new ResultEntity();
        result.setTestEntity(testEntity);
        result.setUserEntity(userEntity);
        result.setSqlDate(new java.sql.Date(System.currentTimeMillis()));

        resultDao.saveResult(result);

        selectedAnswers.forEach((k, v) -> {
            if (!k.equals("_csrf")) {
                for (String s : v) {
                    ResultDetailEntity resultDetailEntity = new ResultDetailEntity();
                    resultDetailEntity.setResultEntity(result);
                    resultDetailEntity.setQuestionEntity(questionService.getQuestion(Integer.parseInt(k)));

                    resultDetailEntity.setAnswerEntity(answerService.getAnswerEntityById(Integer.parseInt(s)));
                    resultDao.saveResultDetail(resultDetailEntity);
                }
            }
        });

        List<ResultDetailEntity> answerEntityList = resultDao.getAnswerEntitySet(result);
        int rightChoosenAnswerCount = getCountOfRightChoosenAnswer(answerEntityList, testEntity.getQuestions());
        float grade = rightChoosenAnswerCount * 100 / testEntity.getQuestions().size();

        result.setGrade(grade);
    }

    private int getCountOfRightChoosenAnswer(List<ResultDetailEntity> resultDetailEntityList, Set<QuestionEntity> questionEntitySet) {
        int rightAnswerCounter = 0;

        for (QuestionEntity questionEntity : questionEntitySet) {
            int countOfCorrectAnswersInQuestions = 0;
            int countOfChoosenAnswers = 0;
            int countOfRightChoosenAnswers = 0;

            for (AnswerEntity answerEntity : questionEntity.getAnswerEntityList()) {
                if (answerEntity.isCorrect()) {
                    countOfCorrectAnswersInQuestions++;

                    for (ResultDetailEntity resultDetailE : resultDetailEntityList) {

                        if (resultDetailE.getAnswerEntity().equals(answerEntity)) {
                            countOfRightChoosenAnswers++;
                        }
                    }
                }
            }
            for (ResultDetailEntity resultDetailE : resultDetailEntityList) {
                if (resultDetailE.getQuestionEntity().getId() == questionEntity.getId())
                    countOfChoosenAnswers++;
            }
            if (countOfCorrectAnswersInQuestions == countOfChoosenAnswers && countOfCorrectAnswersInQuestions == countOfRightChoosenAnswers) {
                rightAnswerCounter++;
            }
        }
        return rightAnswerCounter;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<ExamResult> getRecentlyResults() {
        return resultDao.getRecentlyResults();
    }

    @Transactional
    public List<ExamResultOfUser> getResultListByUser(UserEntity userEntity) {
        return resultDao.getResultListByUser(userEntity);
    }

    @Transactional
    public List<ExamResultDetail> getQuestionResults(int id) {
        return resultDao.getQuestionResults(id);
    }

    @Transactional
    public List<Integer> getChoosenAnswersIdList(int resuldId) {
        List<Integer> choosenAnswersIdList = new ArrayList<>();

        resultDao.getChoosenAnswersIdList(resuldId).forEach(r ->
                choosenAnswersIdList.add(r.getAnswerEntity().getId()));

        return choosenAnswersIdList;
    }

    @Transactional
    public ResultEntity getLastExamination(UserEntity userEntity) {
        return resultDao.getLastExamination(userEntity);
    }
}
