package exampro.containerClasses;

import exampro.entity.AnswerEntity;
import exampro.entity.QuestionEntity;

import java.util.List;

public class QuestionContainer {
    private QuestionEntity questionEntity;
    private List<AnswerEntity> answerEntityList;

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    public List<AnswerEntity> getAnswerEntityList() {
        return answerEntityList;
    }

    public void setAnswerEntityList(List<AnswerEntity> answerEntityList) {
        this.answerEntityList = answerEntityList;
    }
}
