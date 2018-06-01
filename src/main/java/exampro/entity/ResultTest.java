package exampro.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table(name="result")
public class ResultTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    TestEntity testEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    QuestionEntity questionEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_id")
    AnswerEntity answerEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TestEntity getTestEntity() {
        return testEntity;
    }

    public void setTestEntity(TestEntity testEntity) {
        this.testEntity = testEntity;
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
        return "ResultTest{" +
                "id=" + id +
                ", testEntity=" + testEntity +
                ", questionEntity=" + questionEntity +
                ", answerEntity=" + answerEntity +
                '}';
    }
}
