package exampro.dao;

import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;

import java.util.List;

public interface QuestionDao {

    public void update(QuestionEntity questionEntity);

    public void delete(int id);

    public List<QuestionEntity> getAllByTestId(TestEntity testEntity);

    QuestionEntity getQuestion(int id);
}
