package exampro.dao;

import exampro.entity.ResultDetailEntity;
import exampro.entity.ResultEntity;
import exampro.entity.UserEntity;
import exampro.reports.ExamResult;
import exampro.reports.ExamResultDetail;
import exampro.reports.ExamResultOfUser;

import java.util.List;

public interface ResultDao {
    void saveResult(ResultEntity result);

    void saveResultDetail(ResultDetailEntity resultDetailEntity);

    List<ExamResult> getRecentlyResults();

    List<ExamResultOfUser> getResultListByUser(UserEntity userEntity);

    List<ExamResultDetail> getQuestionResults(int id);

    List<ResultDetailEntity> getAnswerEntitySet(ResultEntity resultEntity);

    List<ResultDetailEntity> getChoosenAnswersIdList(int resultId);

    ResultEntity getLastExamination(UserEntity userEntity);
}
