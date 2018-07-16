package exampro.dao;

import exampro.entity.AnswerEntity;
import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.entity.UserEntity;
import exampro.reports.ExamResult;
import exampro.reports.ExamResultDetail;
import exampro.reports.ExamResultOfUser;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ResultDao {
    void saveResult(ResultEntity result);

    ResultEntity getResultEntityById(int id);

    void saveResultDetail(ResultDetailEntity resultDetailEntity);

    List<ExamResult> getRecentlyResults();

    List<ExamResultOfUser> getResultListByUser(UserEntity userEntity);

    List<ExamResultDetail> getResultsByExam(int id);

    List<ResultDetailEntity> getAnswerEntitySet(ResultEntity resultEntity);
}
