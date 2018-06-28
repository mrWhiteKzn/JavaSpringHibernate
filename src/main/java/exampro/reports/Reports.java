package exampro.reports;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public class Reports {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ExamResult> getExamResults(String login){
        String query = "SELECT new exampro.reports.ExamResult(u.login, r.testEntity.name, 0, r.sqlDate) " +
                "FROM ResultEntity r, UserEntity u " +
                "WHERE r.userEntity.id = u.id "+
                "ORDER BY r.sqlDate DESC";

        if (sessionFactory == null) System.out.println("### NULL!!!!");
        Session session = sessionFactory.getCurrentSession();
        Query hibernateQuery = session.createQuery(query);
        return hibernateQuery.list();
    }
}
