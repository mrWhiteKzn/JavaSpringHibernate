package exampro.config;

import exampro.entity.QuestionEntity;
import exampro.entity.TestEntity;

import java.util.List;

public class TestContainer {
    TestEntity testEntity;
    private List<QuestionEntity> questionEntityList;

    public TestContainer(TestEntity testEntity, List<QuestionEntity> questionEntityList) {
        this.testEntity = testEntity;
        this.questionEntityList = questionEntityList;
    }

    public TestEntity getTestEntity() {
        return testEntity;
    }

    public void setTestEntity(TestEntity testEntity) {
        this.testEntity = testEntity;
    }

    public List<QuestionEntity> getQuestionEntityList() {
        return questionEntityList;
    }

    public void setQuestionEntityList(List<QuestionEntity> questionEntityList) {
        this.questionEntityList = questionEntityList;
    }

    @Override
    public String toString() {
        return "TestContainer{" +
                "testEntity=" + testEntity +
                ", questionEntityList=" + questionEntityList +
                '}';
    }
}
