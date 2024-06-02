package ru.javarush.vasilev.quest.rawtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.vasilev.quest.entity.Answer;
import ru.javarush.vasilev.quest.entity.Quest;
import ru.javarush.vasilev.quest.entity.QuestionView;
import ru.javarush.vasilev.quest.entity.ViewType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Quest quest = new Quest();
        quest.setTitle("Квест №1");

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

        try(FileWriter writer = new FileWriter("src/main/resources/json/quest01.json")){
            mapper.writeValue(writer, quest);
        }
//        Scanner scanner = new Scanner(System.in);
//        ObjectMapper mapper = new ObjectMapper();
//        QuestionView view = new QuestionView();
//        try(FileReader fr = new FileReader("src/main/resources/json/out.json")) {
//            Quest quest2 = new Quest();
//            String file = fr.toString();
//            quest2 = mapper.readValue(fr, Quest.class);
//            try(StringWriter sw = new StringWriter()) {
//                mapper.writeValue(sw, quest2);
//                String test = sw.getBuffer().toString();
//                String correctString = new String(sw.getBuffer().toString().replaceAll("\"", "\\\""));
//                System.out.println(sw.toString());
//            }
//            view = quest2.getCurrentView();
//        }
    }
}