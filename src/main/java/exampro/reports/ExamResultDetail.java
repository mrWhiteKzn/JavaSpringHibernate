package exampro.reports;

public class ExamResultDetail {
    private String questionName;
    private String choosenAnswer;
    private String correctAnswer;

    public ExamResultDetail(String questionName, String choosenAsnwer, String correctAnswer) {
        this.questionName = questionName;
        this.choosenAnswer = choosenAsnwer;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getChoosenAnswer() {
        return choosenAnswer;
    }

    public void setChoosenAnswer(String choosenAnswer) {
        this.choosenAnswer = choosenAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
