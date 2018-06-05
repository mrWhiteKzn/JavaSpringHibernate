package exampro.dao;

import exampro.config.HibernateUtil;
import exampro.entity.ResultEntity;
import org.hibernate.Session;

public class ResultDaoImp implements  ResultDao {
    @Override
    public void saveResult(ResultEntity resultEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(resultEntity);
        session.close();
    }
}
