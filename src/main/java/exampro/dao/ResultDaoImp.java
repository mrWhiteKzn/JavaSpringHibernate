package exampro.dao;

import exampro.config.HibernateUtil;
import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import org.hibernate.Session;

public class ResultDaoImp implements  ResultDao {
    @Override
    public void saveResult(ResultEntity resultEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(resultEntity);
        session.close();
    }

    @Override
    public ResultEntity getResultEntityById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ResultEntity resultEntity = (ResultEntity) session.load("ResultEntity", id);
        session.close();
        return resultEntity;
    }

    @Override
    public void saveResultDetail(ResultDetailEntity resultDetailEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(resultDetailEntity);
        session.close();
    }
}
