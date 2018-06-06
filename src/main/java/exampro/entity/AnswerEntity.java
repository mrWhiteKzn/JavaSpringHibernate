package exampro.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "isCorrect")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    @Override
    public String toString() {
        return "AnswerEntity{" +
                "id=" + id +
                ", answerText='" + answerText + '\'' +
                ", isCorrect=" + isCorrect +
                ", questionEntity=" + questionEntity +
                '}';
    }
}
