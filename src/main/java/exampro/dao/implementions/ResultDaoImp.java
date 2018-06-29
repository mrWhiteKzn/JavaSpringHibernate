package exampro.dao.implementions;

import exampro.dao.ResultDao;
import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.reports.ExamResult;
import exampro.reports.Reports;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResultDaoImp implements ResultDao {

    SessionFactory sessionFactory;
    Reports reports;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public void setReports(Reports reports) {
        this.reports = reports;
    }

    @Override
    public void saveResult(ResultEntity resultEntity) {
        sessionFactory.getCurrentSession().save(resultEntity);
    }

    @Override
    public ResultEntity getResultEntityById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (ResultEntity) session.load("ResultEntity", id);
    }

    @Override
    public void saveResultDetail(ResultDetailEntity resultDetailEntity) {
        Session session = sessionFactory.getCurrentSession();
        if (session != null) {
            System.out.println("#### NOT NULLLLL");
        } else {
            System.out.println("####### NULL!!!");
        }
        System.out.println(resultDetailEntity.toString());
        session.save(resultDetailEntity);
    }

    @Override
    public List<ExamResult> getRecentlyResults() {
        return reports.getExamResults("white");
    }
}
