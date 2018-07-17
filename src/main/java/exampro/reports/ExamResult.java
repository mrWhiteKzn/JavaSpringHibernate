package exampro.reports;

public class ExamResult {
    private int id;
    private String userName;
    private String examName;
    private java.util.Date sqlDate;
    private float grade;

    public ExamResult(int id, String userName, String examName, float grade, java.util.Date sqlDate) {
        this.id = id;
        this.userName = userName;
        this.examName = examName;
        this.sqlDate = sqlDate;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
