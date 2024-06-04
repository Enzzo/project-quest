package ru.javarush.vasilev.quest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import ru.javarush.vasilev.quest.entity.Answer;
import ru.javarush.vasilev.quest.entity.SessionStats;
import ru.javarush.vasilev.quest.service.QuestService;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    private QuestService questService = new QuestService();
    private SessionStats session = new SessionStats();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String param = request.getParameter("game");
        String idx = request.getParameter("idx");
        String invalidate = request.getParameter("invalidate");

        if(!StringUtils.isBlank(name)) {
            session.setUserName(name);
        }
        session.setIP(getClientIpAddr(request));

        if(StringUtils.equals(param, "start")){
            questService.load(0);
        }
        if(StringUtils.isNumeric(idx)){
            questService.setNextQuestion(Integer.parseInt(idx));
        }

        String title = questService.getTitle();
        request.setAttribute("title", title);

        String text = questService.getText();
        request.setAttribute("text", text);

        String state = questService.getType();
        if(StringUtils.equals(state, "win")){
            session.win();
            request.setAttribute("state", "game over");
        }
        else if(StringUtils.equals(state, "lose")){
            session.lose();
            request.setAttribute("state", "game over");
        }

        List<Answer> answers = questService.getAnswers();
        request.setAttribute("answers", answers);

        request.setAttribute("session", session);

        getServletContext().getRequestDispatcher("/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }

    private static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}