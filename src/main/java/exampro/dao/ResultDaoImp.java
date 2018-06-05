package exampro.dao;

import exampro.config.HibernateUtil;
import exampro.entity.Result;
import org.hibernate.Session;

public class ResultDaoImp implements  ResultDao {
    @Override
    public void saveResult(Result result) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(result);
        session.close();
    }
}
