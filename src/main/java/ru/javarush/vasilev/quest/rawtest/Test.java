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
        String prologue = "<div><h2>Пролог</h2>" +
                "<p>Ты стоишь в космическом порту и готов подняться на борт" +
                "своего корабля. Разве ты не об этом мечтал? Стать капитаном" +
                "галактического судна с экипажем, который будет совершать" +
                "подвиги под твоим командованием." +
                "Так что вперёд!</p></div>" +
                "<div><h2>Знакомство с экипажем</h2><p>" +
                "Когда ты поднялся на борт корабля, тепя поприветствовала девушка с чёрной папкой в руках:<br>" +
                "- Здравствууйте, командир! я Зинаида - ваша помощница. Видите? Там в углу пьёт кофе" +
                "наш штурман - сержант Перегарный Шлейф, под штурвалом спит наш бортмеханик - Чёрный Богдан," +
                "А как обращаться к вам?</p></div>";
        quest.setTitle(prologue);

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

        try(FileWriter writer = new FileWriter("src/main/resources/json/quest03.json")){
            mapper.writeValue(writer, quest);
        }
//        Scanner scanner = new Scanner(System.in);
//        ObjectMapper mapper = new ObjectMapper();
//        QuestionView view = new QuestionView();
//        try(FileReader fr = new FileReader("src/main/resources/json/quest02.json")) {
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