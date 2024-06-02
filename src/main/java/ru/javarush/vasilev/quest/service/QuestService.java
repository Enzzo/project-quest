package ru.javarush.vasilev.quest.service;

import ru.javarush.vasilev.quest.entity.Answer;
import ru.javarush.vasilev.quest.entity.Quest;
import ru.javarush.vasilev.quest.entity.QuestionView;
import ru.javarush.vasilev.quest.repository.QuestsRepository;

import java.util.List;

public class QuestService {
    private Quest quest = new Quest();
    private QuestionView currentView = new QuestionView();

    public void load(Integer id){
            currentView = QuestsRepository.getInstance().getQuestSourceById(id).getCurrentView();
    }

    //  TODO: отправить текст текущего вопроса
    public String getText(){
        return currentView.getQuestion();
    }

    //  TODO: отправить список текущего вопроса
    public List<Answer> getAnswers(){
        return currentView.getAnswers();
    }

    //  TODO: назначить новое активное окно вопроса по индексу, прилетевшему с фронта
    public void setNextQuestion(Integer idx){
        currentView = currentView.getAnswerByIndex(idx).getNextView();
    }
}
