package s.www.assignment2;

public class Questions {
    private String imgFilename;
    private String question;
    private String [] answers = new String[4];
    private int correctAnswer;
    private String answerExplanation;

    public String getImgFilename() {
        return imgFilename;
    }

    public void setImgFilename(String imgFilename) {
        this.imgFilename = imgFilename;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerExplanation() {
        return answerExplanation;
    }

    public void setAnswerExplanation(String answerExplanation) {
        this.answerExplanation = answerExplanation;
    }

    @Override
    public String toString()
    {
        String res="";
        res+="Image file path : "+this.imgFilename+"\n";
        res+="Question : "+this.question+"\n";
        res+="Answers : "+this.answers.toString()+"\n";
        res+="Correct : "+this.correctAnswer+"\n";
        res+="Answer Explanation : "+this.answerExplanation+"\n";
        res+="----------------------------------------\n";

        return res;
    }
}
