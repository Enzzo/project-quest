package ru.javarush.vasilev.quest.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Question
 * Содержит список ответов, либо результат выбора ответа
 * win or lose
 */
@JsonAutoDetect
public class QuestionView{
    private String question = new String();
    private List<Answer> answers = new ArrayList<Answer>();
    private ViewType type = ViewType.NEXT;

    public ViewType getType() {
        return type;
    }

    public void setType(ViewType type) {
        this.type = type;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Answer getAnswerByIndex(int index) {
        return answers.get(index);
    }
}