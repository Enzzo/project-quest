package ru.javarush.vasilev.quest.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import ru.javarush.vasilev.quest.entity.Answer;
import ru.javarush.vasilev.quest.service.QuestService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    private QuestService questService = new QuestService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String param = request.getParameter("game");
        String idx = request.getParameter("idx");

        if(StringUtils.equals(param, "start")){
            questService.load(0);
        }
        if(StringUtils.isNumeric(idx)){
            questService.setNextQuestion(Integer.parseInt(idx));
        }

        String text = questService.getText();
        request.setAttribute("text", text);

        List<Answer> answers = questService.getAnswers();
        request.setAttribute("answers", answers);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }
}