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

import java.util.*;

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

//        List<ResultDetailEntity> answerEntityList = resultDao.getAnswerEntitySet(result);
//        int rightChoosenAnswerCount = getCountOfRightChoosenAnswer(answerEntityList, testEntity.getQuestions());
//        float grade = rightChoosenAnswerCount * 100 / testEntity.getQuestions().size();

        result.setGrade(calculateGradeOfExamResult(result));
    }

    @Transactional
    public float calculateGradeOfExamResult(ResultEntity result) {
        float grade = 0;

        List<ResultDetailEntity> answerEntityList = resultDao.getAnswerEntitySet(result);               // 1. get list of all choosen answers by student;
        Set<QuestionEntity> questionEntitySet = result.getTestEntity().getQuestions();                  // 2. get list of all questions in the exam;
        int rightChoosenAnswerCount = getCountOfRightChoosenAnswer(answerEntityList, questionEntitySet);// 3. calculate the count of right choosen answers;
        grade = rightChoosenAnswerCount * 100 / questionEntitySet.size();                               // 4. calculate grade.

        return grade;
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
    public Map<Integer, Float> getLastExaminationShortResult(UserEntity userEntity) {
        ResultEntity resultEntity = resultDao.getLastExamination(userEntity);
        float grade = calculateGradeOfExamResult(resultEntity);

        Map<Integer, Float> results = new HashMap<>();
        results.put(resultEntity.getId(), grade);

        return results;
    }
}
