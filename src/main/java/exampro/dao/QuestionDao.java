package exampro.dao;

import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;

import java.util.List;

public interface QuestionDao {

    void update(QuestionEntity questionEntity);

    void delete(int id);

    List<QuestionEntity> getAllByTestId(TestEntity testEntity);

    QuestionEntity getQuestion(int id);

    void saveOrUpdate(QuestionEntity questionEntity);

}
