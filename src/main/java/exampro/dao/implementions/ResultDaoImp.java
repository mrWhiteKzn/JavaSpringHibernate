package exampro.dao.implementions;

import exampro.dao.ResultDao;
import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.entity.UserEntity;
import exampro.reports.ExamResult;
import exampro.reports.ExamResultDetail;
import exampro.reports.ExamResultOfUser;
import exampro.reports.Reports;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.query.Query;
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
        session.save(resultDetailEntity);
    }

    @Override
    public List<ExamResult> getRecentlyResults() {
        return reports.getExamResults();
    }

    @Override
    public List<ExamResultOfUser> getResultListByUser(UserEntity userEntity) {
        return reports.getExamResultByUser(userEntity);
    }

    @Override
    public List<ExamResultDetail> getResultsByExam(int id) {
        return reports.getResultsByExam(id);
    }

    @Override
    public List<ResultDetailEntity> getAnswerEntitySet(ResultEntity resultEntity) {
        Session session = sessionFactory.getCurrentSession();

        String query = "from ResultDetailEntity where resultEntity.id =:id";
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("id", resultEntity.getId());

        return hibernateQuery.list();
    }
}
