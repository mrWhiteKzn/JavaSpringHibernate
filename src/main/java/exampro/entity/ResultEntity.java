package exampro.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="result")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private TestEntity testEntity;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "answer_id")
//    private AnswerEntity answerEntity;

    @Basic
    @Column(name = "sqlDate")
    private java.sql.Date sqlDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

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

//    public AnswerEntity getAnswerEntity() {
//        return answerEntity;
//    }

//    public void setAnswerEntity(AnswerEntity answerEntity) {
//        this.answerEntity = answerEntity;
//    }

    public Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
