package exampro.entity;

import javax.persistence.*;

@Entity
@Table(name="resultDetail")
public class ResultDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="result_id")
    private ResultEntity resultEntity;

    @ManyToOne
    @JoinColumn(name="question_id")
    private QuestionEntity questionEntity;

    @ManyToOne
    @JoinColumn(name="answer_id")
    private AnswerEntity answerEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ResultEntity getResultEntity() {
        return resultEntity;
    }

    public void setResultEntity(ResultEntity resultEntity) {
        this.resultEntity = resultEntity;
    }

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    public AnswerEntity getAnswerEntity() {
        return answerEntity;
    }

    public void setAnswerEntity(AnswerEntity answerEntity) {
        this.answerEntity = answerEntity;
    }

    @Override
    public String toString() {
        return "ResultDetailEntity{" +
                "id=" + id +
                ", resultEntity=" + resultEntity +
                ", questionEntity=" + questionEntity +
                ", answerEntity=" + answerEntity +
                '}';
    }
}
