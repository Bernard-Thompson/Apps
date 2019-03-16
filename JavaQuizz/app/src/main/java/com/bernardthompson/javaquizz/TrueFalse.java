package com.bernardthompson.javaquizz;

public class TrueFalse {

    private int bQuestionID;
    private boolean bAnswer;


    public TrueFalse (int QuestionID, boolean trueOrFalse) {
        bQuestionID = QuestionID;
        bAnswer = trueOrFalse;
    }

    public int getQuestionID() {
        return bQuestionID;
    }

    public void setQuestionID(int bQuestionID) {
        this.bQuestionID = bQuestionID;
    }

    public boolean isAnswer() {
        return bAnswer;
    }

    public void setAnswer(boolean bAnswer) {
        this.bAnswer = bAnswer;
    }
}
