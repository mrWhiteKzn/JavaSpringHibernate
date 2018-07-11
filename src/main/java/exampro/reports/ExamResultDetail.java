package exampro.reports;

public class ExamResultDetail {
    private String questionName;
    private String choosenAnswer;
    private boolean correct;

    public ExamResultDetail(String questionName, String choosenAsnwer, boolean correct) {
        this.questionName = questionName;
        this.choosenAnswer = choosenAsnwer;
        this.correct = correct;
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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
