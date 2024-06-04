package ru.javarush.vasilev.quest.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.vasilev.quest.entity.Answer;
import ru.javarush.vasilev.quest.entity.Quest;
import ru.javarush.vasilev.quest.entity.QuestionView;
import ru.javarush.vasilev.quest.entity.ViewType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Этот класс пока работает в ручном режиме для создания квестов
 * Во время работы приложения он нигде не используется (пока)
 */
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

        QuestionView view3 = new QuestionView();
        view3.setQuestion("Ты принял вызов.<br>Поднимешься на мостик к капитану?");
        view3.setType(ViewType.NEXT);

        QuestionView view4 = new QuestionView();
        view4.setQuestion("Ты поднялся на мостик.<br>ты кто?");
        view4.setType(ViewType.NEXT);

        QuestionView view5 = new QuestionView();
        view5.setQuestion("Ты не прошел на переговоры<br>Поражение");
        view5.setType(ViewType.LOSE);

        QuestionView view6 = new QuestionView();
        view6.setQuestion("Тебя вернули домой.<br>Победа");
        view6.setType(ViewType.WIN);

        QuestionView view7 = new QuestionView();
        view7.setQuestion("Твою ложь разоблачили.<br>Поражение");
        view7.setType(ViewType.LOSE);

        Answer ans1 = new Answer();
        ans1.setAnswer("Принять вызов");
        ans1.setNextView(view3);

        Answer ans2 = new Answer();
        ans2.setAnswer("Отклонить вызов");
        ans2.setNextView(view2);

        List<Answer> answers1 = new ArrayList<>();
        answers1.add(ans1);
        answers1.add(ans2);
        view1.setAnswers(answers1);

        Answer ans3 = new Answer();
        ans3.setAnswer("Подняться на мостик");
        ans3.setNextView(view4);

        Answer ans4 = new Answer();
        ans4.setAnswer("Отказаться подниматься на мостик");
        ans4.setNextView(view5);

        List<Answer> answers3 = new ArrayList<>();
        answers3.add(ans3);
        answers3.add(ans4);
        view3.setAnswers(answers3);

        Answer ans5 = new Answer();
        ans5.setAnswer("Рассказать о себе правду");
        ans5.setNextView(view6);

        Answer ans6 = new Answer();
        ans6.setAnswer("Солгать о себе");
        ans6.setNextView(view7);


        List<Answer> answers5 = new ArrayList<>();
        answers5.add(ans5);
        answers5.add(ans6);
        view4.setAnswers(answers5);

        quest.setTitle("Квест #1");
        quest.setCurrentView(view1);
        try(FileWriter writer = new FileWriter("src/main/resources/json/quest01.json")){
            mapper.writerWithDefaultPrettyPrinter().writeValue(writer, quest);
        }

        Quest quest2 = new Quest();
        try(FileReader reader = new FileReader("src/main/resources/json/quest01.json")){
            quest2 = mapper.readValue(reader, Quest.class);
            int kx =1;
        }
    }
}