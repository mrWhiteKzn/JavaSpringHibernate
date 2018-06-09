package exampro.reports;

import exampro.config.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Reports {
    public List<ExamResult> getExamResults(String login){
        String query = "SELECT new exampro.reports.ExamResult(u.login, r.testEntity.name, 0, r.sqlDate) " +
                "FROM ResultEntity r, UserEntity u " +
                "WHERE r.userEntity.id = u.id "+
                "ORDER BY r.sqlDate DESC";

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query hibernateQuery = session.createQuery(query);
        List<ExamResult> list = hibernateQuery.list();
        return hibernateQuery.list();
    }
}
