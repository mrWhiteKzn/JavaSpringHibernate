package exampro.dao.implementions;

import exampro.dao.ResultDao;
import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.entity.UserEntity;
import exampro.reports.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public List<ExamResultDetail> getQuestionResults(int id) {
        return reports.getExamResultDetailList(id);
    }

    @Override
    public List<ResultDetailEntity> getAnswerEntitySet(ResultEntity resultEntity) {
        Session session = sessionFactory.getCurrentSession();

        String query = "from ResultDetailEntity where resultEntity.id =:id";
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("id", resultEntity.getId());

        return hibernateQuery.list();
    }

    @Override
    public List<ResultDetailEntity> getChoosenAnswersIdList(int resultId) {
        Session session = sessionFactory.getCurrentSession();

        String query = "from ResultDetailEntity where resultEntity.id =:resultId";
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("resultId", resultId);

        return hibernateQuery.list();
    }

    @Override
    public ResultEntity getLastExamination(UserEntity userEntity) {
        Session session = sessionFactory.getCurrentSession();

        String query = "from ResultEntity where userEntity =:user order by id DESC ";
        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setMaxResults(1);
        hibernateQuery.setParameter("user", userEntity);

        return (ResultEntity) hibernateQuery.uniqueResult();
    }
}
