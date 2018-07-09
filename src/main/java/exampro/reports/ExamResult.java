package exampro.reports;

public class ExamResult {
    private String userName;
    private String examName;
    private java.util.Date sqlDate;
    private int grade;

    public ExamResult(String userName, String examName, int grade, java.util.Date sqlDate) {
        this.userName = userName;
        this.examName = examName;
        this.sqlDate = sqlDate;
        this.grade = grade;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
