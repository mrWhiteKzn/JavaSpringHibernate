package exampro.entity;

import javax.persistence.*;

@Entity
@Table(name="resultDetail")
public class ResultDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="result_id")
    Result result;

    @ManyToOne
    @JoinColumn(name="question_id")
    QuestionEntity questionEntity;

    @ManyToOne
    @JoinColumn(name="answer_id")
    AnswerEntity answerEntity;
}
