package exampro.reports;

import exampro.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Reports {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ExamResult> getExamResults() {
        String query = "SELECT new exampro.reports.ExamResult(r.id, u.login, r.testEntity.name, r.grade, r.sqlDate) " +
                "FROM ResultEntity r, UserEntity u " +
                "WHERE r.userEntity.id = u.id "+
                "ORDER BY r.id DESC";

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

    public List<ExamResultDetail> getResultsByExam(int id) {
        String query = "SELECT new exampro.reports.ExamResultDetail(q.questionText, a.answerText, a.correct) " +
                "FROM QuestionEntity q, AnswerEntity a, ResultDetailEntity r " +
                "WHERE r.answerEntity.id=a.id " +
                "AND r.questionEntity.id=q.id " +
                "AND r.resultEntity.id =:resultId";


        Session session = sessionFactory.getCurrentSession();
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("resultId", id);

        List<ExamResultDetail> examResultDetailList = hibernateQuery.list();
        return examResultDetailList;
    }
}
