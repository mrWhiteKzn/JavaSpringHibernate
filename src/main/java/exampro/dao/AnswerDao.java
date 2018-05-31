package exampro.dao;

import exampro.entity.AnswerEntity;
import exampro.entity.QuestionEntity;

import java.util.List;

public interface AnswerDao {

    void saveOrUpdate(AnswerEntity answerEntity, QuestionEntity questionEntity);

    void saveorUpdateList(List<AnswerEntity> answerEntityList, QuestionEntity questionEntity);

    void delete(AnswerEntity answerEntity);

    List<AnswerEntity> getAnswerList();
}
