package ru.javarush.vasilev.quest.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Answer {
    private String answer;
    private QuestionView nextView;

    public void setNextView(QuestionView nextView){
        this.nextView = nextView;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public QuestionView getNextView(){
        return this.nextView;
    }
}