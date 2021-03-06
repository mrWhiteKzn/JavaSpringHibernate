package exampro.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "result")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private TestEntity testEntity;

    @Basic
    @Column(name = "sqlDate")
    private java.sql.Date sqlDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @JoinColumn(name = "grade")
    private float grade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resultEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ResultDetailEntity> resultDetailEntityList;

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

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "id=" + id +
                ", testEntity=" + testEntity +
                ", sqlDate=" + sqlDate +
                ", userEntity=" + userEntity +
                ", resultDetailEntityList=" + resultDetailEntityList +
                '}';
    }
}
