package exampro.reports;

import java.util.Date;

public class ExamResultOfUser {
    private int id;
    private String testName;
    private java.util.Date date;
    private int grade;

    public ExamResultOfUser(int id, String testName, Date date, int grade) {
        this.id = id;
        this.testName = testName;
        this.date = date;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
