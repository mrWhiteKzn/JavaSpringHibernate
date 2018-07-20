package exampro.reports;

import exampro.entity.*;
import exampro.service.TestService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class Reports {

    SessionFactory sessionFactory;
    TestService testService;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public List<ExamResult> getExamResults() {
        String query = "SELECT new exampro.reports.ExamResult(r.id, u.login, u.id, r.testEntity.name, r.sqlDate, r.grade) " +
                "FROM ResultEntity r, UserEntity u " +
                "WHERE r.userEntity.id = u.id " +
                "ORDER BY r.id DESC ";

        Session session = sessionFactory.getCurrentSession();
        Query hibernateQuery = session.createQuery(query);
        return hibernateQuery.list();
    }

    public List<ExamResultOfUser> getExamResultByUser(UserEntity userEntity) {
        String query = "SELECT new exampro.reports.ExamResultOfUser(r.id, r.testEntity.name, r.sqlDate, r.grade) " +
                "FROM ResultEntity r " +
                "WHERE r.userEntity.id = :userId " +
                "ORDER BY r.sqlDate DESC";

        Session session = sessionFactory.getCurrentSession();
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("userId", userEntity.getId());

        List<ExamResultOfUser> examResultOfUserList = hibernateQuery.list();
        return examResultOfUserList;
    }

    public List<ExamResultDetail> getExamResultDetailList(int resultId) {

        List<ExamResultDetail> examResultDetailList = new ArrayList<>();
        List<QuestionResultDetail> questionResultDetailList = getQuestionResults(resultId);

        Set<QuestionEntity> questionEntitySet = testService.getTestEntity(questionResultDetailList.get(0).getTestId()).getQuestions();
        for (QuestionEntity question : questionEntitySet) {
            System.out.println("###### question ID" + question.getId());
            List<String> correctAnswerText = new ArrayList<>();
            List<String> choosenAnswerText = new ArrayList<>();
            boolean questionAnsweredRight = false;

            for (AnswerEntity answer : question.getAnswerEntityList()) {
                if (answer.isCorrect())
                    correctAnswerText.add(answer.getAnswerText());
            }

            for (QuestionResultDetail questionResult : questionResultDetailList) {
                if (questionResult.getQuestionId() == question.getId()) {
                    choosenAnswerText.add(questionResult.getChoosenAnswer());
                }
            }

            if (choosenAnswerText.size() == correctAnswerText.size()) {
                Collections.sort(choosenAnswerText);
                Collections.sort(correctAnswerText);
                questionAnsweredRight = choosenAnswerText.equals(correctAnswerText);
            }
            examResultDetailList.add(new ExamResultDetail(question.getId(), question.getQuestionText(), questionAnsweredRight));
            Collections.sort(examResultDetailList);
        }
        return examResultDetailList;
    }

    public List<QuestionResultDetail> getQuestionResults(int resultId) {
        String query = "SELECT new exampro.reports.QuestionResultDetail(q.questionText, q.id, a.answerText, a.correct, t.id) " +
                "FROM QuestionEntity q, AnswerEntity a, ResultDetailEntity r, TestEntity  t " +
                "WHERE r.answerEntity.id=a.id " +
                "AND r.questionEntity.id=q.id " +
                "AND r.questionEntity.testEntity.id = t.id " +
                "AND r.resultEntity.id =:resultId";

        Session session = sessionFactory.getCurrentSession();
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("resultId", resultId);
        List<QuestionResultDetail> questionResultDetailList = hibernateQuery.list();
        return questionResultDetailList;
    }
}
