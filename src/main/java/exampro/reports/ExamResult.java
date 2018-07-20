package exampro.reports;

import java.util.Date;

public class ExamResult {
    private int resultId;
    private String userName;
    private int userId;
    private String examName;
    private java.util.Date sqlDate;
    private float grade;

    public ExamResult(int resultId, String userName, int userId, String examName, Date sqlDate, float grade) {
        this.resultId = resultId;
        this.userName = userName;
        this.userId = userId;
        this.examName = examName;
        this.sqlDate = sqlDate;
        this.grade = grade;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public java.util.Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(java.util.Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
