package exampro.containerClasses;

import exampro.entity.AnswerEntity;

import java.util.List;

public class AnswerContainer {
    private List<AnswerEntity> answerEntityList;

    public List<AnswerEntity> getAnswerEntityList() {
        return answerEntityList;
    }

    public void setAnswerEntityList(List<AnswerEntity> answerEntityList) {
        this.answerEntityList = answerEntityList;
    }

    public void add(AnswerEntity answerEntity){
        this.answerEntityList.add(answerEntity);
    }
}
