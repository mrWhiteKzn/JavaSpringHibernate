package exampro.containerClasses;

import exampro.entity.AnswerEntity;

import java.util.ArrayList;
import java.util.List;

public class AnswerContainer {
    private List<AnswerEntity> answerEntityList = new ArrayList<AnswerEntity>();

    public AnswerContainer() {
    }

    public AnswerContainer(List<AnswerEntity> answerEntitySet) {
        this.answerEntityList = answerEntitySet;
    }

    public List<AnswerEntity> getAnswerEntityList() {
        return answerEntityList;
    }

    public void setAnswerEntityList(List<AnswerEntity> answerEntityList) {
        this.answerEntityList = answerEntityList;
    }


}
