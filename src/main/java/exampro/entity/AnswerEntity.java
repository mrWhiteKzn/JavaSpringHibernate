package exampro.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "Correct")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;

    @OneToMany(mappedBy = "answerEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ResultDetailEntity> resultDetailEntityList;

    public List<ResultDetailEntity> getResultDetailEntityList() {
        return resultDetailEntityList;
    }

    public void setResultDetailEntityList(List<ResultDetailEntity> resultDetailEntityList) {
        this.resultDetailEntityList = resultDetailEntityList;
    }

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
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

}
