package exampro.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question_text", columnDefinition = "text")
    private String questionText;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private TestEntity testEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionEntity", cascade = CascadeType.REMOVE)
    private List<AnswerEntity> answerEntityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public TestEntity getTestEntity() {
        return testEntity;
    }

    public void setTestEntity(TestEntity testEntity) {

        this.testEntity = testEntity;
    }

    public List<AnswerEntity> getAnswerEntityList() {
        return answerEntityList;
    }

    public void setAnswerEntityList(List<AnswerEntity> answerEntityList) {
        this.answerEntityList = answerEntityList;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", testEntity=" + testEntity +
                ", answerEntitySet=" + answerEntityList +
                '}';
    }
}
