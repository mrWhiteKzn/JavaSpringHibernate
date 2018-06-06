package exampro.dao;

import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;

public interface ResultDao {
    void saveResult(ResultEntity result);

    ResultEntity getResultEntityById(int id);

    void saveResultDetail(ResultDetailEntity resultDetailEntity);
}
