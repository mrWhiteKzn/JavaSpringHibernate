package exampro.reports;

public class ExamResultDetail implements Comparable<ExamResultDetail> {
    private int questionId;
    private String questionText;
    private boolean correct;

    public ExamResultDetail(int questionId, String questionText, boolean correct) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.correct = correct;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public int compareTo(ExamResultDetail examResultDetail) {
        return Integer.compare(questionId, examResultDetail.questionId);
    }
}
