package exampro.dao;

import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.reports.ExamResult;

import java.util.List;
import java.util.Map;

public interface ResultDao {
    void saveResult(ResultEntity result);

    ResultEntity getResultEntityById(int id);

    void saveResultDetail(ResultDetailEntity resultDetailEntity);

    List<ExamResult> getRecentlyResults();
}
