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
        view1.setQuestion("Выбери правильный ответ:");
        view1.setType(ViewType.NEXT);

        QuestionView view2 = new QuestionView();
        view2.setQuestion("Правильно");
        view2.setType(ViewType.WIN);

        Answer left = new Answer();
        left.setAnswer("Левая");
        left.setNextView(view2);

        QuestionView view3 = new QuestionView();
        view3.setQuestion("Не правильно");
        view3.setType(ViewType.LOSE);

        Answer right = new Answer();
        right.setAnswer("Правая");
        right.setNextView(view3);

        List<Answer> answers = new ArrayList<>();
        answers.add(left);
        answers.add(right);

        view1.setAnswers(answers);
        quest.setCurrentView(view1);

        try(FileWriter writer = new FileWriter("src/main/resources/json/quest04.json")){
            mapper.writeValue(writer, quest);
        }
    }
}