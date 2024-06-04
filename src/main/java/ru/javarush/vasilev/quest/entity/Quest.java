package ru.javarush.vasilev.quest.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Содержит список вопросов и отображений {@code Question}
 *
 */
@JsonAutoDetect
public class Quest {
    private String title = null;
    private QuestionView currentView = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public QuestionView getCurrentView() {
        return currentView;
    }

    public void setCurrentView(QuestionView currentView) {
        this.currentView = currentView;
    }
}
