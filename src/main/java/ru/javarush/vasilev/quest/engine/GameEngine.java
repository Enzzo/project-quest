package ru.javarush.vasilev.quest.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.vasilev.quest.entity.Answer;
import ru.javarush.vasilev.quest.entity.Quest;
import ru.javarush.vasilev.quest.entity.QuestionView;
import ru.javarush.vasilev.quest.entity.ViewType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Quest quest = new Quest();

        QuestionView view1 = new QuestionView();
        view1.setQuestion("Ты потерял память.<br>Принять вызов НЛО?");
        view1.setType(ViewType.NEXT);

        QuestionView view2 = new QuestionView();
        view2.setQuestion("Ты отклонил вызов.<br>Поражение");
        view2.setType(ViewType.LOSE);

        Answer ans1 = new Answer();
        ans1.setAnswer("Отклонить вызов");
        ans1.setNextView(view2);

        QuestionView view3 = new QuestionView();
        view3.setQuestion("Ты принял вызов.<br>Поднимешься на мостик к капитану?");
        view3.setType(ViewType.NEXT);

        Answer ans2 = new Answer();
        ans2.setAnswer("Принять вызов");
        ans2.setNextView(view3);

        List<Answer> answers = new ArrayList<>();
        answers.add(ans1);
        answers.add(ans2);

        view1.setAnswers(answers);
        quest.setCurrentView(view1);

        try(FileWriter writer = new FileWriter("src/main/resources/json/quest05.json")){
            mapper.writeValue(writer, quest);
        }
    }
}